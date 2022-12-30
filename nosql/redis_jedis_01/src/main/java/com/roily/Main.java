package com.roily;

import com.roily.util.JedisFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {
    public static void main(String[] args) {
        final GenericObjectPoolConfig<Jedis> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(1024);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        JedisPool pool = new JedisPool(config, "10.211.55.4", 6379, 6000, "123123");
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
    public void jedisPool(){
        final Jedis jedis = JedisFactory.jedis();
        System.out.println(jedis.get("key"));
        JedisFactory.close(jedis);
    }

}