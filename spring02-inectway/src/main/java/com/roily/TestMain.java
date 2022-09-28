package com.roily;

import com.roily.common.config.AConfig;
import com.roily.common.config.ApplicationConfig;
import com.roily.common.config.ConfigDemo;
import com.roily.entity.Component1;
import com.roily.entity.Component2;
import com.roily.entity.Person;
import com.roily.entity.User;
import com.roily.service.ServiceDemo;
import com.roily.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/09/27/14:07
 * @Description:
 */
public class TestMain {


    @Test
    public void test1() {

        final ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:application.xml");

        final User user1 = cpx.getBean("user", User.class);
        System.out.println(user1);

        final User user = cpx.getBean("userAlias", User.class);
        System.out.println(user);

        final User userByName = (User) cpx.getBean("user");
        System.out.println(userByName);

        final User userAlias = (User) cpx.getBean("userAlias");
        System.out.println(userAlias);

        final User userByType = cpx.getBean(User.class);
        System.out.println(userByType);


        final Object person = cpx.getBean("person", Person.class);
        System.out.println(person);

    }

    @Test
    public void testAutoWrite() {

        final ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("application.xml");

        final UserService bean = cpx.getBean(UserService.class);
        System.out.println(bean);

    }

    @Test
    public void testAutoWrite2() {

        final ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final UserService bean = ac.getBean(UserService.class);
        System.out.println(bean);

    }


    /**
     * 循环依赖
     */
    @Test
    public void testAutoWritex() {

        final ApplicationContext ac = new AnnotationConfigApplicationContext(AConfig.class);

        final Component1 bean1 = ac.getBean(Component1.class);
        final Component2 bean2 = ac.getBean(Component2.class);
        bean1.method();

    }

    /**
     * 循环依赖
     */
    @Test
    public void testAutoWritexx() {

        final ApplicationContext cpx = new ClassPathXmlApplicationContext("application.xml");
        final Component1 bean1 = cpx
                .getBean(Component1.class);

        bean1.method();

    }


    /**
     * @AutoWrite
     */
    @Test
    public void testAutoWritexxx() {

        final ApplicationContext cpx = new ClassPathXmlApplicationContext("ApplicationDaoDemo.xml");
        final ServiceDemo serviceDemo = cpx
                .getBean(ServiceDemo.class);

    }
    /**
     * @AutoWrite
     */
    @Test
    public void testAutoWritexxxconfig() {

        final ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigDemo.class);

        final Object serviceDemo = ac.getBean("serviceDemo");
    }

}
