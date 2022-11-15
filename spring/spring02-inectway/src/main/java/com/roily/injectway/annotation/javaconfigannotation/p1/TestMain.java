package com.roily.injectway.annotation.javaconfigannotation.p1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/10/11/11:08
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        final ApplicationContext application = new AnnotationConfigApplicationContext(JavaConfig.class);


        System.out.println();
    }
}
