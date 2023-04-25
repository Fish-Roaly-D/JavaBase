package com.roily.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisBigHashTest {

    private Jedis jedis;
    final Logger logger = LoggerFactory.getLogger(getClass());

    final static int STR_MAX_LEN = 10 * 1024;
    final static int HASH_MAX_LEN = 500/*3*/;

    @BeforeEach
    private void init() {
        jedis = new Jedis("10.211.55.4", 6380);
        jedis.auth("123123");
    }

    @Test
    void testSetBigKey() {
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 500; i++) {
            map.put("key" + i, "value" + i);
        }
        jedis.hmset("hash:total:500", map);
    }

    @Test
    void testSetBigKey1000() {
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 1000; i++) {
            map.put("key" + i, "value" + i);
        }
        jedis.hmset("hash:total:1000", map);
    }

    @Test
    void testSetBigKey100_000_0() {
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 100_000_0; i++) {
            map.put("key" + i, "value" + i);
        }
        jedis.hmset("hash:total:100_000_0", map);
    }


    @Test
    void testBigString() {
        for (int i = 1; i <= 100_000_0; i++) {
            jedis.set("str:total:100_000_0:" + i, "value" + i);
        }
    }

    @Test
    void testSmallHash() {
        int hashSize = 500;
        // 初始化避免频繁扩容
        Map<String, String> map = new HashMap<>(hashSize);
        for (int i = 1; i <= 100_000_0; i++) {
            // 取整作为key
            int k = (i - 1) / hashSize;
            // 取余作为field
            int v = i % hashSize;
            map.put("key_" + v, "value_" + v);
            if (v == 0) {
                jedis.hmset("test:small:hash_" + k, map);
            }
        }
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}