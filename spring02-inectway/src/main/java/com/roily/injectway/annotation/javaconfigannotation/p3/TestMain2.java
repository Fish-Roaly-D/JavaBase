package com.roily.injectway.annotation.javaconfigannotation.p3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/10/11/11:08
 * @Description:
 */
public class TestMain2 {
    public static void main(String[] args) {
        final ApplicationContext application = new AnnotationConfigApplicationContext(JavaConfig2.class);


        System.out.println();
    }
}
