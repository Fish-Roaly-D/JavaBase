package com.roily.autowriteresourceinject.inject.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/10/12/17:49
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        final ApplicationContext acp = new AnnotationConfigApplicationContext(JavaConfig.class);

        System.out.println();
    }
}
