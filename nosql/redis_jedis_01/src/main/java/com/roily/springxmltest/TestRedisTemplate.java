package com.roily.springxmltest;

import com.roily.config.RedisConfigration;
import com.roily.util.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Arrays;
import java.util.List;

/**
 * @author: rolyfish
 */
@Data
@Slf4j
public class TestRedisTemplate {

    @Test
    public void test1() {
        final ApplicationContext app = new ClassPathXmlApplicationContext("classpath:application.xml");
        final String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        final RedisTemplate redisTemplate = app.getBean(RedisTemplate.class);
        final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
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


    /**
     * 对非string的key和value 需要设置序列化工具
     */
    @Test
    public void test3() {
        final ApplicationContext app = new AnnotationConfigApplicationContext(RedisConfigration.class);

        final RedisTemplate redisTemplate = app.getBean(RedisTemplate.class);
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        final ListOperations<String, User> listOperations = redisTemplate.opsForList();
        final List<User> users = Arrays.asList(new User("李自成", 21), new User("李自成", 21));
        final Long count = listOperations.leftPushAll("users", users);
        System.out.println(count);

        final List<User> users2 = listOperations.range("users",0,listOperations.size("users"));
        users2.forEach(System.out::println);

        final User users1 = listOperations.leftPop("users");
        System.out.println(users1);

    }
}
