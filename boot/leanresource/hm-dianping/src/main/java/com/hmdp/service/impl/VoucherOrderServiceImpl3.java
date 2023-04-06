package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.connection.stream.StreamReadOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.LOCK_USER_KEY;
import static com.hmdp.utils.RedisConstants.LOCK_USER_TIMEOUT;
import static com.hmdp.utils.RedisConstants.LOCK_USER_TTL;
import static com.hmdp.utils.RedisConstants.SECKILL_STREAMQUEUEORDER_KEY;
import static com.hmdp.utils.RedisConstants.UNIQUE_ID_KEY_ORDER;

/**
 * <p>
 * 基于阻塞队列实现秒杀
 * </p>
 *
 * @author rolyfish
 */
@Slf4j
@Service
public class VoucherOrderServiceImpl3 extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {


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

    // 设置容量防止溢出
    private final static BlockingQueue<VoucherOrder> ORDER_TASKS = new ArrayBlockingQueue<>(1024 * 1024);
    // 线程池
    private static final ExecutorService SECKILL_EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), r -> new Thread(r));

    private IVoucherOrderService voucherOrderServiceProxy = null;

    // 当类初始化之后执行此方法
/*    @PostConstruct
    private void init() {
        SECKILL_EXECUTOR_SERVICE.submit(() -> {
            // 从阻塞对列拿订单信息,并创建
            while (true) {
                final VoucherOrder voucherOrder = ORDER_TASKS.take();
                handleVoucherOrder(voucherOrder);
            }
        });
    }*/

    @PostConstruct
    private void init() {
        SECKILL_EXECUTOR_SERVICE.submit(() -> {
            while (true) {
                try {
                    // 读取Stream消息队列中的值 XREADGROUP GROUP group consumer [COUNT count] [BLOCK milliseconds] [NOACK] STREAMS key [key ...] ID [ID ...]
                    final List<MapRecord<String, Object, Object>> orderList = redisTemplate.opsForStream().read(
                            Consumer.from("g1", "c1"),
                            StreamReadOptions.empty().count(1).block(Duration.ofSeconds(2)),
                            StreamOffset.create(SECKILL_STREAMQUEUEORDER_KEY, ReadOffset.lastConsumed())
                    );
                    // 判断是否获取成功

                    if (null == orderList || orderList.size() == 0) {
                        // 获取失败或者没有值继续循环
                        continue;
                    }
                    // 有值  解析成 VoucherOrder 并存储
                    handleRecordList(orderList);
                } catch (Exception e) {
                    log.info("处理订单异常:{}", e.getMessage());
                    handlePendingList();
                }
            }
        });
    }

    private void handlePendingList() {
        while (true) {
            try {
                // 读取pending-list已消费未确认的消息   XREADGROUP GROUP group consumer [COUNT count] [BLOCK milliseconds] [NOACK] STREAMS key [key ...] ID [ID ...]
                final List<MapRecord<String, Object, Object>> orderList = redisTemplate.opsForStream().read(
                        Consumer.from("g1", "c1"),
                        StreamReadOptions.empty().count(1).block(Duration.ofSeconds(2)),
                        StreamOffset.create(SECKILL_STREAMQUEUEORDER_KEY, ReadOffset.from("0"))
                );
                // 判断是否获取成功
                if (null == orderList || orderList.size() == 0) {
                    // 获取失败,没有待确认消息,跳出循环
                    break;
                }
                // 有值  解析成 VoucherOrder 并存储
                handleRecordList(orderList);
            } catch (Exception e) {
                log.info("处理pending-list订单异常:{}", e.getMessage());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    log.info("异常");
                }
            }
        }
    }

    private void handleRecordList(List<MapRecord<String, Object, Object>> orderList) {
        final MapRecord<String, Object, Object> order = orderList.get(0);
        final Map<Object, Object> orderMap = order.getValue();
        final VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(orderMap, new VoucherOrder(), CopyOptions.create().ignoreError());
        // 下单
        handleVoucherOrder(voucherOrder);
        // 确认  XACK key group ID [ID ...]
        redisTemplate.opsForStream().acknowledge(SECKILL_STREAMQUEUEORDER_KEY, "g1", order.getId());
    }

    /**
     * 线程池中调用的此方法,获取不到代理对象,需要在主线程获取
     */
    private void handleVoucherOrder(VoucherOrder voucherOrder) {
        // 1.查询优惠券信息
        Long voucherId = voucherOrder.getVoucherId();
        final SeckillVoucher seckillVoucher = seckillVoucherService.getById(voucherId);
        // 2. 判断起始时间
        if (seckillVoucher.getBeginTime().isAfter(LocalDateTime.now())) {
            log.info("秒杀未开始");
            return;
        }
        if (seckillVoucher.getEndTime().isBefore(LocalDateTime.now())) {
            log.info("秒杀已经结束");
            return;
        }
        // 3. 判断库存
        if (seckillVoucher.getStock() <= 0) {
            log.info("库存不足");
            return;
        }
        RLock redisLock = null;
        try {
            redisLock = redisson.getLock(LOCK_USER_KEY + voucherOrder.getUserId());
            final boolean b = redisLock.tryLock(LOCK_USER_TIMEOUT, LOCK_USER_TTL, TimeUnit.SECONDS);
            if (!b) {
                log.info("不要重复下单!!");
                return;
            }
            voucherOrderServiceProxy.createVoucherOrder(voucherOrder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            assert redisLock != null;
            redisLock.unlock();
        }
    }


    @Override
    public Result seckillVoucher(Long voucherId) {

        // 悲观锁
        //return pessimismLock(voucherId);
        // 乐观锁
        //return optimisticLock(voucherId);
        // 分段锁
        //return splitLock(voucherId);

        // lua脚本实现秒杀
        return luaSeckillOrder(voucherId);
    }

    private static final DefaultRedisScript<Long> SECKILL_SCRIPT = new DefaultRedisScript<>();

    static {
        SECKILL_SCRIPT.setLocation(new ClassPathResource("lua/seckill-up.lua"/*"lua/seckill.lua"*/));
        SECKILL_SCRIPT.setResultType(Long.class);
    }

    /*    private Result luaSeckillOrder(Long voucherId) {
        UserDTO user = UserHolder.getUser();
        final Long result = redisTemplate.execute(SECKILL_SCRIPT,
                Collections.emptyList(),
                user.getId().toString(),
                voucherId.toString());
        assert result != null;
        final int resultI = result.intValue();
        if (resultI != 0) {
            return Result.fail(resultI == 1 ? "库存不足x" : "您已经下过单了" + user.getId());
        }

        // 创建订单信息放入阻塞队列
        // 1.1 全军唯一订单ID
        long orderId = redisIdWorker.nextId(UNIQUE_ID_KEY_ORDER);
        // 1.2 用户ID
        long userid = user.getId();
        final VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setId(orderId);
        voucherOrder.setUserId(userid);
        voucherOrder.setVoucherId(voucherId);
        try {
            ORDER_TASKS.put(voucherOrder);
        } catch (InterruptedException e) {
            log.info("线程终端异常");
        }
        voucherOrderServiceProxy = (IVoucherOrderService) AopContext.currentProxy();
        return Result.ok("用户:" + user.getId() + "购买订单:" + voucherId + "成功");
    }*/


    /**
     * lua脚本实现秒杀,并加入消息队列 redis单线程
     * - 初始化 lua脚本
     * - 执行lua脚本
     */
    private Result luaSeckillOrder(Long voucherId) {
        UserDTO user = UserHolder.getUser();
        long orderId = redisIdWorker.nextId(UNIQUE_ID_KEY_ORDER);
        final Long result = redisTemplate.execute(SECKILL_SCRIPT,
                Collections.emptyList(),
                user.getId().toString(),
                voucherId.toString(), String.valueOf(orderId),
                SECKILL_STREAMQUEUEORDER_KEY);
        assert result != null;
        final int resultI = result.intValue();
        if (resultI != 0) {
            return Result.fail(resultI == 1 ? "库存不足x" : "您已经下过单了" + user.getId());
        }
        voucherOrderServiceProxy = (IVoucherOrderService) AopContext.currentProxy();
        return Result.ok("用户:" + user.getId() + "购买订单:" + voucherId + "成功");
    }

    /**
     * 悲观锁解决超卖问题
     * - 锁订单ID
     * - 锁粒度   字符串常量池的字符串
     * - 适合单机环境
     *
     * @return Result.class
     */
    @Transactional
    public Result pessimismLock(Long voucherId) {
        synchronized ((voucherId + "").intern()) {
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
     * @param voucherId 定单id
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
        final Integer count = this.query().allEq(map).count();
        if (count > 0) {
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

    @Transactional
    @Override
    public Result createVoucherOrder(VoucherOrder voucherOrder) {
        final Long voucherId = voucherOrder.getVoucherId();
        final Long userId = voucherOrder.getUserId();
        // 判断此用户是否已
        // 经下过单
        final Map<String, Object> map = new HashMap<>();
        map.put("voucher_id", voucherId);
        map.put("user_id", userId);
        final Integer count = this.query().allEq(map).count();
        if (count > 0) {
            return Result.fail("该用户" + userId + "已经下过单");
        }
        // 4. 扣减库存， ==扣减库存时判断库存是否被修改过==
        final boolean success = seckillVoucherService.update().setSql("stock = stock-1").eq("voucher_id", voucherId)
                //.eq("stock", seckillVoucher.getStock())
                .gt("stock", 0).update();
        // 如果更新失败则重试
        if (!success) {
            return luaSeckillOrder(voucherId);
        }
        // 保存订单
        this.save(voucherOrder);
        // 6.返回订单
        return Result.ok(voucherOrder);
    }

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
        int flag = (Thread.currentThread().getId() + "").hashCode() & 1;
        return flag > 0 ? optimisticLock(voucherId) : optimisticLockAdd(voucherId);
    }

}
