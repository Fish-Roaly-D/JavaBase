package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.errorprone.annotations.Var;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.Voucher;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.service.IVoucherService;
import com.hmdp.utils.RedisIdWorker;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.connection.stream.StreamReadOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ValueRange;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.hmdp.utils.RedisConstants.UNIQUE_ID_KEY_ORDER;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Slf4j
@Service
public class VoucherOrderServiceImpl2 extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {


    @Autowired
    IVoucherService voucherService;

    @Autowired
    ISeckillVoucherService seckillVoucherService;

    @Autowired
    RedisIdWorker redisIdWorker;

    @Override
    public Result seckillVoucher(Long voucherId) {
        // 1.查询优惠券信息
        final SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
        // 2. 判断起始时间
        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
            return Result.fail("秒杀未开始");
        }
        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
            return Result.fail("秒杀已经结束");
        }
        // 3. 判断库存
        if (voucher.getStock() < 0) {
            return Result.fail("库存不足");
        }
        // 4. 扣减库存
        final boolean success = seckillVoucherService.update()
                .setSql("stock = stock-1")
                .eq("voucher_id", voucherId).update();
        if (!success) {
            return Result.fail("库存不足");
        }
        // 5.创建订单
        final UserDTO user = UserHolder.getUser();
        final VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setVoucherId(voucherId);
        voucherOrder.setUserId(user.getId());
        // 订单id
        voucherOrder.setId(redisIdWorker.nextId(UNIQUE_ID_KEY_ORDER));
        // 6.返回订单
        return Result.ok(voucherOrder);
    }
}
