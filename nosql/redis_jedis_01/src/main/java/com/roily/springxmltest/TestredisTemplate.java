package com.roily.springxmltest;

import com.roily.config.RedisConfigration;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author: rolyfish
 */
@Data
public class TestredisTemplate {

    @Test
    public void test1() {
        final ApplicationContext app = new ClassPathXmlApplicationContext("classpath:application.xml");
        final String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        final RedisTemplate redisTemplate = app.getBean(RedisTemplate.class);
        final ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("redistemplate", "value");
        System.out.println(valueOperations.get("redistemplate"));
    }
    @Test
    public void test2() {
        final ApplicationContext app = new AnnotationConfigApplicationContext(RedisConfigration.class);
        final String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        final RedisTemplate redisTemplate = app.getBean(RedisTemplate.class);
        final ValueOperations valueOperations = redisTemplate.opsForValue();
        System.out.println(valueOperations.get("redistemplate"));
    }
}
