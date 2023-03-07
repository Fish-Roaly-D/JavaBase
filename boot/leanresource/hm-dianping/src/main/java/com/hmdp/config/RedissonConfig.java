package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(){
        // 配置
        Config config = new Config();
          config.useSingleServer().setAddress("redis://10.211.55.4:6379").setPassword("123123");
        //config.useSingleServer().setAddress("redis://127.0.0.1:6379")/*.setPassword("123123")*/;
        // 创建RedissonClient对象
        return Redisson.create(config);
    }

}
