package com.roily.injectway.annotation.xmlannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/10/11/10:08
 * @Description:
 */
public class TestMain2 {

    public static void main(String[] args) {

        final ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:ApplicationAnnotationXml2.xml");

        System.out.println();
    }

}
