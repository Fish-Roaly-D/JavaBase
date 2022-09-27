package com.roily;

import com.roily.common.config.ApplicationASConfig;
import com.roily.common.config.ApplicationConfig;
import com.roily.entity.User;
import com.roily.service.UserService;
import com.roily.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Date: 2022/09/22/19:05
 * @Description:
 */
public class demo {

    public static void main(String[] args) {

        // final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // final UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        // final List<User> all = userService.getAll();
        // System.out.println(all);

        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationASConfig.class);
        final UserService userService = ac.getBean("userServiceImpl", UserService.class);
        final List<User> all = userService.getAll();
        System.out.println(all);
    }
}
