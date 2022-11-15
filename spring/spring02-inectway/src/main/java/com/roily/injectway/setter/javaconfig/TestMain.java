package com.roily.injectway.setter.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/10/10/10:22
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {

        final ApplicationContext apx = new AnnotationConfigApplicationContext(SetterConfig.class);
        System.out.println();

    }
}
