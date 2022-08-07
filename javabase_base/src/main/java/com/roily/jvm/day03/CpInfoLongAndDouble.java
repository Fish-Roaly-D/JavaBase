package com.roily.jvm.day03;

import org.junit.Test;

/**
 * @classname：CpInfoIntAndFloat
 * @author: rolyfish
 * @description: int 和 float 常量池
 * @date: 2022/8/7 13:45
 */
public class CpInfoLongAndDouble {

    long l1 = 123L;
    Long l2 = 123L;

    double d1 = 123D;
    Double d2 = 123D;


    @Test
    public  void test() {

        Long l = 123L;
        System.out.println(l == l2);

        Long l2 = 1234L;

        Integer i1 = 32769;
        Integer i2 = 32769;

        System.out.println(i1 == i2);

    }

}