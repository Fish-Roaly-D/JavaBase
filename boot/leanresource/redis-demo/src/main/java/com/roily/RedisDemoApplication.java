package com.roily;

import com.roily.redis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
@Slf4j
public class RedisDemoApplication {

    public static void main(String[] args) {
        final ApplicationContext app = SpringApplication.run(RedisDemoApplication.class, args);
        //打印beannames
        final String[] beanNames = app.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        /**
         * 得到redisTemplate并进行插入查询操作
         */
        final RedisTemplate redisTemplate = app.getBean("redisTemplate",RedisTemplate.class);
        final ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();

        final User user = new User("李自成",21);
        valueOperations.set("user:1",user);
        final Object user1 = valueOperations.get("user:1");
        log.info("user1:{}",user1);
    }

}
