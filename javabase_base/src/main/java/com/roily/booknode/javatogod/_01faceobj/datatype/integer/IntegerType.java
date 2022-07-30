package com.roily.booknode.javatogod._01faceobj.datatype.integer;

import org.junit.Test;

/**
 * @classname：IntegerType
 * @author: rolyfish
 * @description: 整型
 * @date: 2022/7/30 16:11
 */
public class IntegerType {


    @Test
    public void test1() {
        System.out.println("int的最大值" + Integer.MAX_VALUE);
        System.out.println("int的最小值" + Integer.MIN_VALUE);
    }

    /**
     * 溢出问题
     */
    @Test
    public void test2() {
        final int value = Integer.MAX_VALUE + Integer.MAX_VALUE;
        System.out.println(value);
    }


}
