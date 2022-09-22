package com.roily;

import com.roily.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/09/22/19:05
 * @Description:
 */
public class demo {

    public static void main(String[] args) {
        final ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        final User user = classPathXmlApplicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
