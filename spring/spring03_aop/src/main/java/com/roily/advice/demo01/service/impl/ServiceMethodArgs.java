package com.roily.advice.demo01.service.impl;

import com.roily.advice.demo01.common.LogAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2022/10/18/10:22
 * @Description:
 */
@Service
@LogAnnotation
@Transactional
public class ServiceMethodArgs {

    public void methodeArgs(String s1,String s2,Integer i3) throws RuntimeException {
        System.out.println("methodeArgs");
    }


    public static void withinM(){
        System.out.println("@within");
    }

}
