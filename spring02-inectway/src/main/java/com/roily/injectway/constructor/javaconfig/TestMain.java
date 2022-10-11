package com.roily.injectway.constructor.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/10/10/14:09
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {

        final ApplicationContext apc = new AnnotationConfigApplicationContext(ConstructorConfig.class);

        System.out.println();

    }

}
