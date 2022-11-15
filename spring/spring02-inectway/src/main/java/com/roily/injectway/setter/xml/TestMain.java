package com.roily.injectway.setter.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/10/10/10:29
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        final ApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:ApplicationSetterXml.xml");


        System.out.println();
    }
}
