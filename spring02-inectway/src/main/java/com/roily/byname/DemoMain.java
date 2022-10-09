package com.roily.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/10/09/15:56
 * @Description:
 */
public class DemoMain {

    public static void main(String[] args) {
        final ApplicationContext apc = new AnnotationConfigApplicationContext(InjectByNameConfig.class);
        System.out.println();
    }

}
