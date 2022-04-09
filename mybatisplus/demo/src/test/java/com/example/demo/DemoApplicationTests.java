package com.example.demo;

import com.example.demo.config.DevEnvironment;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    User user;

    @Autowired
    DevEnvironment devEnvironment;

    @Test
    void contextLoads() {

        System.out.println(devEnvironment.isEnableSwagger());
        System.out.println(user);
    }

}
