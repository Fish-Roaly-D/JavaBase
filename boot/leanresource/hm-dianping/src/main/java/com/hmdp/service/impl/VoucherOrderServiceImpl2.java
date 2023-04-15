package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.SeckillVoucherAdd;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherAddService;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.service.IVoucherService;
import com.hmdp.utils.RedisIdWorker;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.LOCK_USER_KEY;
import static com.hmdp.utils.RedisConstants.LOCK_USER_TIMEOUT;
import static com.hmdp.utils.RedisConstants.LOCK_USER_TTL;
import static com.hmdp.utils.RedisConstants.UNIQUE_ID_KEY_ORDER;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author rolyfish
 */
@Slf4j
@Service
public class VoucherOrderServiceImpl2 extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {


    @Override
    public Result createVoucherOrder(VoucherOrder voucherId) {
        return null;
    }

    @Autowired
    IVoucherService voucherService;

    @Autowired
    ISeckillVoucherService seckillVoucherService;

    @Autowired
    ISeckillVoucherAddService seckillVoucherAddService;

    @Autowired
    RedisIdWorker redisIdWorker;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    @Qualifier("redissonClient")
    RedissonClient redisson;

    @Override
    public Result seckillVoucher(Long voucherId) {

        // 悲观锁
        //return pessimismLock(voucherId);
        // 乐观锁
        return optimisticLock(voucherId);
        // 分段锁
        //return splitLock(voucherId);
    }

    /**
     * 悲观锁解决超卖问题
     * - 锁订单ID
     * - 锁粒度   字符串常量池的字符串
     * - 适合单机环境
     * todo 此方法设计事务，必须重写接口方法，此处不正确
     * @return Result.class
     */
    @Transactional
    public Result pessimismLock(Long voucherId) {
        synchronized ((String.valueOf(voucherId)).intern()) {
            // 1.查询优惠券信息
            final SeckillVoucher seckillVoucher = seckillVoucherService.getById(voucherId);
            // 2. 判断起始时间
            if (seckillVoucher.getBeginTime().isAfter(LocalDateTime.now())) {
                return Result.fail("秒杀未开始");
            }
            if (seckillVoucher.getEndTime().isBefore(LocalDateTime.now())) {
                return Result.fail("秒杀已经结束");
            }
            // 3. 判断库存
            if (seckillVoucher.getStock() <= 0) {
                return Result.fail("库存不足");
            }
            // 4. 扣减库存
            final boolean success = seckillVoucherService.update().setSql("stock = stock-1").eq("voucher_id", seckillVoucher.getVoucherId()).update();
            if (!success) {
                return Result.fail("库存不足");
            }
            // 5.创建订单
            final UserDTO user = UserHolder.getUser();
            final VoucherOrder voucherOrder = new VoucherOrder();
            voucherOrder.setVoucherId(seckillVoucher.getVoucherId());
            voucherOrder.setUserId(user.getId());
            // 订单id
            voucherOrder.setId(redisIdWorker.nextId(UNIQUE_ID_KEY_ORDER));
            // 保存订单
            this.save(voucherOrder);
            // 6.返回订单
            return Result.ok(voucherOrder);
        }
    }

    /**
     * 乐观锁解决超卖问题
     * - 添加版本号字段
     * - 首先获取优惠券，修改时判断当前优惠券版本号和之前拿到的版本号是否相同
     * - - 相同则扣减库存
     * - - 不同则重试
     * 此时 库存就可以作为版本号，不用新加字段
     *
     * @return Result.class
     */

    Result optimisticLock(Long voucherId) {
        // 1.查询优惠券信息
        final SeckillVoucher seckillVoucher = seckillVoucherService.getById(voucherId);
        // 2. 判断起始时间
        if (seckillVoucher.getBeginTime().isAfter(LocalDateTime.now())) {
            return Result.fail("秒杀未开始");
        }
        if (seckillVoucher.getEndTime().isBefore(LocalDateTime.now())) {
            return Result.fail("秒杀已经结束");
        }
        // 3. 判断库存
        if (seckillVoucher.getStock() <= 0) {
            return Result.fail("库存不足");
        }
        final UserDTO user = UserHolder.getUser();
        final Long userId = user.getId();
        RLock redisLock = null;
        try {
            // 分布式锁  使用用户id作为key
            //final ILock redisLock = new MyDefinedSimpleRedisLock(LOCK_USER_KEY + userId, redisTemplate);
            //这就是一个可重入锁
            redisLock = redisson.getLock(LOCK_USER_KEY + userId);
            final boolean b = redisLock.tryLock(LOCK_USER_TIMEOUT, LOCK_USER_TTL, TimeUnit.SECONDS);
            if (!b) {
                // 重试或者失败
                //return optimisticLock(voucherId);
                // 重复下单是不允许的可以返回失败
                return Result.fail("不要重复下单!!");
            }
            // 获取当前对象的代理对象,Spring会为我们生成代理对象来处理事务
            final IVoucherOrderService voucherOrderService = (IVoucherOrderService) AopContext.currentProxy();
            // this当前对象调用方法事务不会生效
            //return this.createVoucherOrder(voucherId);
            return voucherOrderService.createVoucherOrder(voucherId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            assert redisLock != null;
            redisLock.unlock();
        }

        //synchronized (userId.toString().intern()) {
        //    // 获取当前对象的代理对象,Spring会为我们生成代理对象来处理事务
        //    final IVoucherOrderService voucherOrderService = (IVoucherOrderService) AopContext.currentProxy();
        //    // this当前对象调用方法事务不会生效
        //    //return this.createVoucherOrder(voucherId);
        //    return voucherOrderService.createVoucherOrder(voucherId);
        //}
    }

    /**
     * 减库存之前需要判断该用户是否已经下过单，然后再执行后续操作
     * 所以这一大段业务都需要加锁，其中涉及查询的业务，所以不使用乐观锁，需要synchronized
     * <p>
     * 锁粒度：不能加方法上，锁对象，使得线程串行，效率底下
     * <p>
     * 既然是一人一单，可以锁用户id
     * <p>
     * 事务问题：
     * synchronized锁释放，但是事务没有提交
     * 解决：对整个方法加锁
     *
     * @param voucherId 订单id
     * @return Result.class
     */
    @Transactional
    @Override
    public Result createVoucherOrder(Long voucherId) {
        final UserDTO user = UserHolder.getUser();
        final Long userId = user.getId();

        // 判断此用户是否已
        // 经下过单
        final Map<String, Object> map = new HashMap<>();
        map.put("voucher_id", voucherId);
        map.put("user_id", userId);
        final Long count = this.query().allEq(map).count();
        if (count !=null && count > 0) {
            return Result.fail("该用户" + userId + "已经下过单");
        }
        // 4. 扣减库存， ==扣减库存时判断库存是否被修改过==
        final boolean success = seckillVoucherService.update().setSql("stock = stock-1").eq("voucher_id", voucherId)
                //.eq("stock", seckillVoucher.getStock())
                .gt("stock", 0).update();
        // 如果更新失败则重试
        if (!success) {
            return optimisticLock(voucherId);
        }
        final VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setVoucherId(voucherId);
        voucherOrder.setUserId(userId);
        // 订单id
        voucherOrder.setId(redisIdWorker.nextId(UNIQUE_ID_KEY_ORDER));
        // 保存订单
        this.save(voucherOrder);
        // 6.返回订单
        return Result.ok(voucherOrder);

    }

    /**
     * 未实现接口
     * @param voucherId 优惠券id
     * @return Result 统一返回结果集
     */
    @Transactional
    public Result optimisticLockAdd(Long voucherId) {
        // 1.查询优惠券信息
        final SeckillVoucherAdd seckillVoucherAdd = seckillVoucherAddService.getById(voucherId);
        // 2. 判断起始时间
        if (seckillVoucherAdd.getBeginTime().isAfter(LocalDateTime.now())) {
            return Result.fail("秒杀未开始");
        }
        if (seckillVoucherAdd.getEndTime().isBefore(LocalDateTime.now())) {
            return Result.fail("秒杀已经结束");
        }
        // 3. 判断库存
        if (seckillVoucherAdd.getStock() <= 0) {
            return Result.fail("库存不足");
        }
        // 4. 扣减库存， ==扣减库存时判断库存是否被修改过==
        final boolean success = seckillVoucherAddService.update().setSql("stock = stock-1").eq("voucher_id", seckillVoucherAdd.getVoucherId())
                //.eq("stock", seckillVoucher.getStock())
                .gt("stock", 0).update();
        // 如果更新失败则重试
        if (!success) {
            return optimisticLock(voucherId);
        }
        // 5.创建订单
        final UserDTO user = UserHolder.getUser();
        final VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setVoucherId(seckillVoucherAdd.getVoucherId());
        voucherOrder.setUserId(user.getId());
        // 订单id
        voucherOrder.setId(redisIdWorker.nextId(UNIQUE_ID_KEY_ORDER));
        // 保存订单
        this.save(voucherOrder);
        // 6.返回订单
        return Result.ok(voucherOrder);
    }

    /**
     * 分段锁解决超卖问题
     * - 添加版本号字段
     * - 首先获取优惠券，修改时判断当前优惠券版本号和之前拿到的版本号是否相同
     * - - 相同则扣减库存
     * - - 不同则重试
     * 此时 库存就可以作为版本号，不用新加字段
     *
     * @return Result.class
     */
    @Transactional
    public Result splitLock(Long voucherId) {
        //对于进来的请求进行散列
        int flag = (String.valueOf(Thread.currentThread().getId())).hashCode() & 1;
        return flag > 0 ? optimisticLock(voucherId) : optimisticLockAdd(voucherId);
    }

}
