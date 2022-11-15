package com.roily.configway.byxml.service.impl;

import com.roily.configway.byxml.service.ServiceDemo;

/**
 * @classname：ServiceDemo
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:25
 */
public class ServiceDemoImpl implements ServiceDemo {

    @Override
    public String methode1() {
        System.out.println("方法一执行");
        return "method1";
    }

    @Override
    public void methode2() {
        System.out.println("方法二执行");
    }

    @Override
    public String methode3() {
        int i = 1 / 0;
        System.out.println("方法三执行");

        return "method3";
    }

}
