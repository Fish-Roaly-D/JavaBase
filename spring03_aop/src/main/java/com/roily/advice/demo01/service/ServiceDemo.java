package com.roily.advice.demo01.service;

/**
 * @classname：ServiceDemo
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:25
 */
public interface ServiceDemo {

    String methode1();

    void methode2();

    String methode3();

    default void method(){
        System.out.println("ServiceDemo default 方法");
    }
}
