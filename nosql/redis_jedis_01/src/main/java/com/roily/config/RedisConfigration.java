package com.roily.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.DefaultJedisClientConfig;

/**
 * @author: rolyfish
 */
public class RedisConfigration {

    public @Bean RedisPassword redisPassword() {
        return RedisPassword.of("123123");
    }
    public @Bean RedisStandaloneConfiguration redisStandaloneConfiguration(@Autowired RedisPassword redisPassword) {
        final RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        // redisStandaloneConfiguration.setPassword(redisPassword);
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        // redisStandaloneConfiguration.setHostName("10.211.55.4");
        redisStandaloneConfiguration.setPort(6379);
        return redisStandaloneConfiguration;
    }
    public @Bean JedisConnectionFactory jedisConnectionFactory(@Autowired RedisStandaloneConfiguration redisStandaloneConfiguration) {
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    public @Bean RedisTemplate redisTemplate(@Autowired JedisConnectionFactory jedisConnectionFactory) {
        final RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }
}
