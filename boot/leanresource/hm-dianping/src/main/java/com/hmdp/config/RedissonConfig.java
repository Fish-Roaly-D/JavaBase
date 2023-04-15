package com.hmdp.config;

import cn.hutool.core.io.resource.ClassPathResource;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @author rolyfish
 */
@Configuration
public class RedissonConfig {

    //@Bean(name = "redissonClient1")
    //public RedissonClient redissonClient() {
    //    // 配置
    //    Config config = new Config();
    //    config.useSingleServer().setAddress("redis://10.211.55.4:6379").setPassword("123123");
    //    //config.useSingleServer().setAddress("redis://127.0.0.1:6379")/*.setPassword("123123")*/;
    //    // 创建RedissonClient对象
    //    return Redisson.create(config);
    //}
    @Bean
    public RedissonClient redissonClient() throws IOException {
        final Config config = Config.fromYAML(new File(new ClassPathResource("redisson.yml").getAbsolutePath()));
        return Redisson.create(config);
    }

    //@Bean(name = "redissonClient1")
    //public RedissonClient redissonClient1() throws IOException {
    //    final Config config = Config.fromYAML(new File(new ClassPathResource("redisson2.yml").getAbsolutePath()));
    //    return Redisson.create(config);
    //}

}
