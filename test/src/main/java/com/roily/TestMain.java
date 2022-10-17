package com.roily;


import com.roily.service.ServiceDemo;
import com.roily.service.impl.ServiceDemoImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @classname：TestMain
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:46
 */
public class TestMain {


    public static void main(String[] args) {

        final ApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:ApplicationConfigAopByXml.xml");
        final ServiceDemo bean = cpx.getBean(ServiceDemo.class);
        bean.methode1();
        bean.methode2();
        bean.methode3();

        final ServiceDemoImpl2 s2 = cpx.getBean(ServiceDemoImpl2.class);
        s2.methode();
    }

}
