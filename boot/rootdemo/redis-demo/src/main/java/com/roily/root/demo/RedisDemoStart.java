package com.roily.root.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AboutAnnocationApplication.java
 * @author: RoilyFish
 * @date: 2022/5/29 16:22
 */
@SpringBootApplication
public class RedisDemoStart {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                SpringApplication.run(RedisDemoStart.class, args);
        displayAllBeans();
    }

    /**
     * 打印所以装载的bean
     */
    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.err.println(beanName);
        }


        final RedisTemplate redisTemplate = (RedisTemplate)applicationContext.getBean("redisTemplate");
            redisTemplate.opsForValue().set("name", "虎哥");
            // 获取string数据
            Object name = redisTemplate.opsForValue().get("name");
            System.out.println("name = " + name);
    }
}
