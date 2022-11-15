package com.roily.advice.demo01;

import com.roily.advice.demo01.common.ApplicationConfig;
import com.roily.advice.demo01.service.ServiceDemo;
import com.roily.advice.demo01.service.impl.ServiceMethodArgs;
import com.roily.advice.demo01.service.impl.T0;
import com.roily.advice.demo01.service.impl.T1;
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

        final ServiceMethodArgs bean1 = acc.getBean(ServiceMethodArgs.class);

        bean1.methodeArgs("", "", 1);

        bean1.withinM();

        T0 t0 = acc.getBean(T0.class);
        T1 t1 = acc.getBean("t1", T1.class);
        t1.method(t0, "");


        final T1 t2 = acc.getBean("t2", T1.class);
        t2.method(t0, "");
    }

}
