package com.roily.booknode.javatogod._02coll.maptest;

import org.junit.Test;

/**
 * @Date: 2023/03/21/15:16
 * @Description:
 */
public class HashMapTest {

    /**
     * jdk17中计算HashMap容量的方法 Integer.numberOfLeadingZeros
     *
     * 二进制值最高位之前0的个数
     * Integer.MAX_VALUE   1
     * Integer.MAX_VALUE-(Integer.MAX_VALUE>>1) - 1   2
     */
    @Test
    public void test1(){

        System.out.println(Integer.numberOfLeadingZeros(2));
        System.out.println(Integer.numberOfLeadingZeros(Integer.MAX_VALUE));
        System.out.println(Integer.numberOfLeadingZeros(Integer.MAX_VALUE-1));
        System.out.println(Integer.numberOfLeadingZeros(Integer.MAX_VALUE-(Integer.MAX_VALUE>>1) - 1));
        System.out.println(Integer.numberOfLeadingZeros(16));
        System.out.println(Integer.numberOfLeadingZeros(8));

    }





}
