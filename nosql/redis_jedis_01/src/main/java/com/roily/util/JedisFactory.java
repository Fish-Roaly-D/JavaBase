package com.roily.util;

import lombok.Data;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.Duration;

/**
 * @author: rolyfish
 */
public class JedisFactory {
    private static JedisPool pool;

    static {
        final GenericObjectPoolConfig<Jedis> config = new GenericObjectPoolConfig<>();
        // 最大连接数
        config.setMaxTotal(10);
        // 最大空闲连接
        config.setMaxIdle(10);
        // 最小空闲连接
        config.setMinIdle(1);
        // 等待时长
        config.setMaxWait(Duration.ofMillis(2000));
        // 从连接池得到连接前会进行校验，校验不通过则销毁当前连接，并借用一个新的连接
        config.setTestOnBorrow(true);
        // 返回结果前对链接进行校验，校验不通过则销毁当前连接
        config.setTestOnReturn(true);
        pool = new JedisPool(config, "10.211.55.4", 6379, 6000, "123123");
    }

    /**
     * 获取jedis实例
     *
     * @return
     */
    public static Jedis jedis() {
        return pool.getResource();
    }

    /**
     * 关闭jedis资源
     *
     * @param jedis
     */
    public static void close(Jedis jedis) {
        jedis.close();
    }

}
