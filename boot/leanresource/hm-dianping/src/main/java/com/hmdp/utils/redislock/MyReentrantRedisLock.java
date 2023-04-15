package com.hmdp.utils.redislock;

import cn.hutool.core.lang.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;

/**
 * @author: rolyfish
 */
public class MyReentrantRedisLock implements ILock {

    public MyReentrantRedisLock(String key, StringRedisTemplate redisTemplate) {
        this.key = key;
        this.redisTemplate = redisTemplate;
    }

    private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "-";
    private final String key;

    private final StringRedisTemplate redisTemplate;
    private final static DefaultRedisScript<Long> UNLOCK_SCRIP = new DefaultRedisScript<>();

    static {
        UNLOCK_SCRIP.setLocation(new ClassPathResource("lua/unlockreentrant.lua"));
        UNLOCK_SCRIP.setResultType(Long.class);
    }

    private final static DefaultRedisScript<Long> LOCK_SCRIP = new DefaultRedisScript<>();

    static {
        LOCK_SCRIP.setLocation(new ClassPathResource("lua/lockreentrant.lua"));
        LOCK_SCRIP.setResultType(Long.class);
    }

    @Override
    public boolean tryLock(long timeoutSec) {
        long result =
                redisTemplate.execute(LOCK_SCRIP, Collections.singletonList(key), ID_PREFIX + Thread.currentThread().getId(), timeoutSec+"");
        return result > 0;
    }

    @Override
    public void unlock() {
        String timeoutSec = "30";
        redisTemplate.execute(UNLOCK_SCRIP, Collections.singletonList(key), ID_PREFIX + Thread.currentThread().getId(), timeoutSec);
    }
}
