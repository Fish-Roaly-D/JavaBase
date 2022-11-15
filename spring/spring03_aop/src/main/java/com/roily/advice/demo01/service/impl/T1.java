package com.roily.advice.demo01.service.impl;

import com.roily.advice.demo01.common.LogAnnotation;
import org.springframework.stereotype.Service;

/**
 * @Date: 2022/10/18/10:58
 * @Description:
 */
@Service("t1")
public class T1 {

    @LogAnnotation(des = "T1")
    public void method(T0 t0, String s) {
        System.out.println("参数列表，持有指定注解");
    }

}
