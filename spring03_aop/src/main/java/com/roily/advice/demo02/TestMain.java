package com.roily.advice.demo02;

import com.roily.advice.demo02.common.ApplicationConfig;
import com.roily.advice.demo02.service.ServiceDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @classname：TestMain
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:46
 */
public class TestMain {


    public static void main(String[] args) {

        final ApplicationContext acc = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final ServiceDemo bean = acc.getBean(ServiceDemo.class);
        bean.methode1();

    }

}
