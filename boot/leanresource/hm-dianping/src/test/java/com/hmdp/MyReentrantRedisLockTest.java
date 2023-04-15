package com.hmdp;

import com.hmdp.utils.redislock.MyReentrantRedisLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author: rolyfish
 */
@Slf4j
@SpringBootTest
public class MyReentrantRedisLockTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void test() {
        final MyReentrantRedisLock myReentrantRedisLock = new MyReentrantRedisLock("LOCK:TEST", redisTemplate);

        method1(myReentrantRedisLock);
    }

    private void method1(MyReentrantRedisLock myReentrantRedisLock) {
        try {
            final boolean b = myReentrantRedisLock.tryLock(30L);
            if (b) {
                log.info(Thread.currentThread().getName() + "method1" + "获取锁");
                method2(myReentrantRedisLock);
            }
        } finally {
            myReentrantRedisLock.unlock();
            log.info(Thread.currentThread().getName() + "method1" + "释放锁");
        }

    }

    private void method2(MyReentrantRedisLock myReentrantRedisLock) {
        try {
            final boolean b = myReentrantRedisLock.tryLock(30L);
            if (b) {
                log.info(Thread.currentThread().getName() + "method2" + "获取锁");
            }
        } finally {
            myReentrantRedisLock.unlock();
            log.info(Thread.currentThread().getName() + "method2" + "释放锁");
        }
    }
}
