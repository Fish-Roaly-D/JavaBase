package com.roily.advice.demo01.service.impl;

import com.roily.advice.demo01.service.ILog;
import com.roily.advice.demo01.service.ServiceDemo;
import org.springframework.stereotype.Service;

/**
 * @classname：ServiceDemo
 * @author: rolyfish
 * @description:
 * @date: 2022/10/14 14:25
 */
@Service
public class ServiceDemoImpl implements ServiceDemo, ILog {

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

    @Override
    public void log() {
        System.out.println("ILog 的 方法");
    }
}
