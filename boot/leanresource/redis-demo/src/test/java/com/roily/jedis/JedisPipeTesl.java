package com.roily.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author: rolyfish
 */
public class JedisPipeTesl {
    private Jedis jedis;
    private Jedis jedisCluster;
    final Logger logger = LoggerFactory.getLogger(getClass());

    @BeforeEach
    public void init() {
        jedis = new Jedis("10.211.55.4", 6380);
        jedisCluster = new Jedis("10.211.55.4", 7001);
        jedis.auth("123123");
    }

    /**
     * 循环插入数据,多次网络io
     */
    @Test
    public void testForSet() {
        for (int i = 0; i < 100_000_0; i++) {
            jedis.set("forset:" + i, "value_" + i);
        }
    }

    /**
     * 利用mset减少网络io
     */
    @Test
    public void testMSet() {
        // 每次插入 1000个k-v
        String[] kvBf = new String[2000];
        for (int i = 0; i < 100_000_0; i += 2) {
            // 0-1998
            int keyIndex = i % 2000;
            int valueIndex = keyIndex + 1;
            kvBf[keyIndex] = "mset:key_" + i / 2;
            kvBf[valueIndex] = "mset_value_" + i / 2;
            if (valueIndex == 1999) {
                jedis.mset(kvBf);
            }
        }
    }

    @Test
    public void testPipelined() {
        // 创建管道
        Pipeline pipelined = jedis.pipelined();
        for (int i = 1; i <= 100_000_0; i++) {
            pipelined.set("pipelined:key:" + i, "value_" + i);
            pipelined.sadd("pipelined:smembers:" + i, "member" + i);
            if (i % 1000 == 0) {
                // 每1000次循环异步执行一次
                pipelined.sync();
            }
        }
    }


    /**
     * jedisCluster = new Jedis("10.211.55.4", 7001);
     * 7001是redis集群中的一个master节点
     */
    @Test
    public void test() {
        String[] kvBf = new String[1000];
        for (int i = 0; i < 100_0; i += 2) {
            // 0-1998
            int keyIndex = i % 2000;
            int valueIndex = keyIndex + 1;
            kvBf[keyIndex] = "mset:key_" + i / 2;
            kvBf[valueIndex] = "mset_value_" + i / 2;
            if (valueIndex == 999) {
                jedisCluster.mset(kvBf);
            }
        }
    }

    @AfterEach
    public void releaseConn() {
        if (null != jedis) {
            jedis.close();
        }
        if (null != jedisCluster) {
            jedisCluster.close();
        }
    }
}
