package com.hmdp;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.service.ISeckillVoucherService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.CACHE_NULL_TTL;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_KEY;
import static com.hmdp.utils.RedisConstants.PASS_THROUGH_VALUE;

/**
 * @author: rolyfish
 */
@SpringBootTest
public class SimpleTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {

        stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + 123, PASS_THROUGH_VALUE, CACHE_NULL_TTL, TimeUnit.MINUTES);

    }

    @Autowired
    ISeckillVoucherService seckillVoucherService;

    @Test
    public void testUpdate() {

        final UpdateWrapper<SeckillVoucher> stock = new UpdateWrapper<SeckillVoucher>().set("stock", 999);

        final boolean update = seckillVoucherService.update(stock);


    }
}

