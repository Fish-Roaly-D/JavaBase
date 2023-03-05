package com.hmdp.utils.redislock;

import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: rolyfish
 */
public class MyDefinedSimpleRedisLock implements ILock {

    /**
     * 分布式锁的key名称
     */
    private String key;

    private StringRedisTemplate stringRedisTemplate;

    public MyDefinedSimpleRedisLock(String key, StringRedisTemplate stringRedisTemplate) {
        this.key = key;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean tryLock(long timeoutSec, TimeUnit timeUnit) {
        return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, Thread.currentThread().getId() + "", timeoutSec, timeUnit));
    }

    @Override
    public boolean tryLock(long timeoutSec) {
        return tryLock(timeoutSec, TimeUnit.SECONDS);
    }

    /**
     * 分布式锁id，这里简单固定，后面需要优化成唯一id
     */
    @Override
    public void unlock() {
        // 释放锁
        stringRedisTemplate.delete(key);
    }
}
