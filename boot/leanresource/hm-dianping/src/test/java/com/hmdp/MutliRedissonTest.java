package com.hmdp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author: rolyfish
 */
@Slf4j
@SpringBootTest
public class MutliRedissonTest {

    //@Autowired
    //@Qualifier("redissonClient1")
    //RedissonClient redissonClient1;
    @Autowired
    @Qualifier("redissonClient")
    RedissonClient redissonClient;
    RLock redissonMultiLock = null;

    //@BeforeEach
    //void setUp() {
    //    final RLock lock1 = redissonClient1.getLock("LOCK:TEST:");
    //    final RLock lock2 = redissonClient.getLock("LOCK:TEST:");
    //    redissonMultiLock = new RedissonMultiLock(lock1, lock2);
    //}

    @Test
    public void test() {
        try {
            final boolean b = redissonMultiLock.tryLock(10, 100, TimeUnit.SECONDS);
            if (b) {
                log.info("联锁获取成功");
            }
        } catch (InterruptedException ignored) {
        } finally {
            redissonMultiLock.unlock();
            log.info("联锁释放");

        }
    }


}
