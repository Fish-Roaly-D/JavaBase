package com.roily.injectway.constructor.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/10/10/14:09
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        final ApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:ApplicationConstructorXml.xml");


        System.out.println();
    }

}
