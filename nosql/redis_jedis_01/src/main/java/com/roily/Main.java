package com.roily;

import com.roily.util.JedisFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
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
        JedisPool pool = new JedisPool(config, "10.211.55.4", 6379, 6000, "123123");
        //JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 6000);
        try (Jedis jedis = pool.getResource()) {
            jedis.auth("123123");
            jedis.set("k1", "v1");
            final String k1 = jedis.get("k1");
            System.out.println(k1);
        }
    }


    @Test
    public void test() {
        final Jedis jedis = new Jedis("10.211.55.4", 6379);
        jedis.auth("123123");
        jedis.set("key", "value");
        System.out.println(jedis.get("key"));
    }

    @Test
    public void jedisPool() {
        final Jedis jedis = JedisFactory.jedis();
        System.out.println(jedis.get("key"));
        // 这里close方法不再是关闭资源，而是将连接归还连接池
        JedisFactory.close(jedis);
    }

}