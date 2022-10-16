package com.roily;

import com.roily.common.config.ApplicationASConfig;
import com.roily.entity.User;
import com.roily.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Date: 2022/09/22/19:05
 * @Description:
 */
public class demo {

    public static void main(String[] args) {

        //final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //final UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        //final List<User> all = userService.getAll();
        //System.out.println(all);

        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationASConfig.class);
        final UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        final List<User> all = userService.getAll();
        System.out.println(all);



    }
}
