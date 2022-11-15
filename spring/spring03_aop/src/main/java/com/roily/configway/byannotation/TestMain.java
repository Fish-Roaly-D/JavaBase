package com.roily.configway.byannotation;

import com.roily.configway.byannotation.common.ApplicationConfig;
import com.roily.configway.byannotation.service.ServiceDemo;
import com.roily.configway.byannotation.service.impl.ServiceDemoImpl2;
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
        System.out.println();

        final ServiceDemoImpl2 serviceDemoImpl2 = acc.getBean(ServiceDemoImpl2.class);
        serviceDemoImpl2.methode();
    }

}
