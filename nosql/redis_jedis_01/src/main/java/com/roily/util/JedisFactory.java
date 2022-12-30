package com.roily.util;

import lombok.Data;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: rolyfish
 */
public class JedisFactory {
    private static JedisPool pool;

    static {
        final GenericObjectPoolConfig<Jedis> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(1024);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        pool = new JedisPool(config, "10.211.55.4", 6379, 6000, "123123");
    }

    /**
     * 获取jedis实例
     * @return
     */
    public static Jedis jedis() {
        return pool.getResource();
    }

    /**
     * 关闭jedis资源
     * @param jedis
     */
    public static void close(Jedis jedis) {
        jedis.close();
    }

}
