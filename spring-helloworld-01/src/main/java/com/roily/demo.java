package com.roily;

import com.roily.entity.User;
import com.roily.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Date: 2022/09/22/19:05
 * @Description:
 */
public class demo {

    public static void main(String[] args) {

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        final List<User> all = userService.getAll();
        System.out.println(all);

    }
}
