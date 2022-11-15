package com.roily.configway.byxml;

import com.roily.configway.byxml.service.ILog;
import com.roily.configway.byxml.service.ServiceDemo;
import com.roily.configway.byxml.service.impl.ServiceDemoImpl2;
import org.springframework.aop.support.AopUtils;
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
        // System.err.println("ServiceDemo  is jdkProxy：" + AopUtils.isJdkDynamicProxy(bean));
        // System.err.println("ServiceDemo  is aopProxy：" + AopUtils.isAopProxy(bean));
        bean.methode1();
        bean.methode2();
        // bean.methode3();

        final ServiceDemoImpl2 s2 = cpx.getBean(ServiceDemoImpl2.class);
        // System.err.println("ServiceDemoImpl2  is cglibProxy：" + AopUtils.isCglibProxy(s2));
        // System.err.println("ServiceDemoImpl2  is aopProxy：" + AopUtils.isAopProxy(s2));
        s2.methode();
    }

}
