package com.hmdp.utils.redislock;

import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: rolyfish
 */
public class MyDefinedSimpleRedisLock implements ILock {

    private static final String KEY_PREV = "lock:";

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
        return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(KEY_PREV + key, Thread.currentThread().getId() + "", timeoutSec, timeUnit));
    }

    @Override
    public boolean tryLock(long timeoutSec) {
        return tryLock(timeoutSec, TimeUnit.SECONDS);
    }

    @Override
    public void unlock() {
        // 释放锁
        stringRedisTemplate.delete(KEY_PREV + key);
    }
}
