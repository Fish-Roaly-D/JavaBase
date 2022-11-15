package com.roily.injectway.annotation.xmlannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/10/11/10:08
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {

        final ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:ApplicationAnnotationXml.xml");

        System.out.println();
    }


}
