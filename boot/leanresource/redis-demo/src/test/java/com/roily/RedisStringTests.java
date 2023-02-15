package com.roily;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roily.redis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Map;

@SpringBootTest
@Slf4j
class RedisStringTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplateSerializer() {
        final ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name2", "李自成");
        valueOperations.set("name3", "lizicheng");
        final String name = (String) valueOperations.get("name");
        System.out.println("name=" + name);
    }

    @Test
    public void testRedisTemplateSerializer2() {
        final ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

        final User user = User.builder().age(22).name("李自成").build();
        valueOperations.set("user", user);
        final User user1 = (User) valueOperations.get("user");
        System.out.println("user=" + user1);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testStringRedisTemplate() {
        final ValueOperations<String, String> valueOperation = stringRedisTemplate.opsForValue();
        // 序列化
        final User user = User.builder().age(22).name("李自成").build();
        final String userStr = JSON.toJSONString(user);
        valueOperation.set("user:1", userStr);
        // 反序列化
        final String s = valueOperation.get("user:1");
        final User user1 = JSON.parseObject(s, User.class);
        log.info("user1:" + user1);
    }


    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:400", "name", "李自成");
        stringRedisTemplate.opsForHash().put("user:400", "age", "21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entries = " + entries);
    }

}
