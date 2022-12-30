package com.roily.springxmltest;

import com.roily.config.RedisConfigration;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

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
        final Set keys = redisTemplate.keys("*");
        final Long delete = redisTemplate.delete(Arrays.asList("redistemplate", "c1", "k1"));
        System.out.println(delete);
        keys.forEach(System.out::println);
        final ValueOperations valueOperations = redisTemplate.opsForValue();
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
