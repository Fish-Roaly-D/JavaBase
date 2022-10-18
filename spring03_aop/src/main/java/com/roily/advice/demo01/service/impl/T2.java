package com.roily.advice.demo01.service.impl;

import com.roily.advice.demo01.service.impl.T0;
import com.roily.advice.demo01.service.impl.T1;
import org.springframework.stereotype.Service;

/**
 * @Date: 2022/10/18/13:10
 * @Description:
 */
@Service("t2")
public class T2 extends T1 {

    @Override
    public void method(T0 t0, String s) {
        System.out.println("t2 为 t1子类，使用within，可以生效");
    }

}
