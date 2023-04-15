package com.roily.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author rolyfish
 * @Date: 2022/10/09/15:56
 * @Description:
 */
public class DemoMain {

    public static void main(String[] args) {
        final ApplicationContext apc = new AnnotationConfigApplicationContext(InjectByTypeConfig.class);
        System.out.println();
    }

}
