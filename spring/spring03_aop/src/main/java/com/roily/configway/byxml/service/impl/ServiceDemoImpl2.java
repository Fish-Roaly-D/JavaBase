package com.roily.configway.byxml.service.impl;

/**
 * @classname：ServiceDemo
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:25
 */
public class ServiceDemoImpl2 {

    public String methode() {
        System.out.println("此类未实现接口，将采用cglib代理 方法一执行");
        return "method1";
    }

}
