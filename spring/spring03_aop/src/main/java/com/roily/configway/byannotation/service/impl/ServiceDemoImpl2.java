package com.roily.configway.byannotation.service.impl;

import org.springframework.stereotype.Service;

/**
 * @classname：ServiceDemo
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:25
 */
@Service
public class ServiceDemoImpl2 {

    public String methode() {
        System.out.println("此类未实现接口，将采用cglib代理 方法一执行");
        return "method1";
    }

}
