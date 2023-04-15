package com.hmdp.utils.redislock;

import cn.hutool.core.lang.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author: rolyfish
 */
public class MyDefinedSimpleRedisLock implements ILock {

    /**
     * 分布式锁的key名称
     */
    private final String key;

    private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "-";

    private final StringRedisTemplate stringRedisTemplate;

    public MyDefinedSimpleRedisLock(String key, StringRedisTemplate stringRedisTemplate) {
        this.key = key;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean tryLock(long timeoutSec, TimeUnit timeUnit) {
        //return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, Thread.currentThread().getId() + "", timeoutSec, timeUnit));
        return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, ID_PREFIX + Thread.currentThread().getId(), timeoutSec, timeUnit));
    }

    @Override
    public boolean tryLock(long timeoutSec) {
        return tryLock(timeoutSec, TimeUnit.SECONDS);
    }

    //@Override
    //public void unlock() {
    //    final String lockValueExpect = ID_PREFIX + Thread.currentThread().getId();
    //    final String lockValue = stringRedisTemplate.opsForValue().get(key);
    //    // 当前线程锁，才释放
    //    if (lockValueExpect.equals(lockValue)) {
    //        // 释放锁
    //        stringRedisTemplate.delete(key);
    //    }
    //}
    private final static DefaultRedisScript<Long> UNLOCK_SCRIP = new DefaultRedisScript<>();
    static {
        UNLOCK_SCRIP.setLocation(new ClassPathResource("lua/unlock.lua"));
        UNLOCK_SCRIP.setResultType(Long.class);
    }
    /**
     * lua脚本释放锁，保证判断是否是当前线程锁的操作和删除锁的操作原子性
     */
    @Override
    public void unlock() {
        stringRedisTemplate.execute(UNLOCK_SCRIP, Collections.singletonList(key), ID_PREFIX + Thread.currentThread().getId());
    }

}
