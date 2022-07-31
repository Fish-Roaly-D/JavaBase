package com.roily.booknode.javatogod._01faceobj.datatype.integer;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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


    /**
     * 装箱拆箱
     */
    @Test
    public void testBoxing() {
        Integer i = 10;
        final int i1 = i.intValue();
    }

    /**
     * 装箱拆箱
     */
    @Test
    public void testBoxing2() {
        Integer i = 10;
        int i2 = i;
    }

    /**
     * 装箱拆箱
     */
    @Test
    public void testBoxing3() {
        List<Integer> ints = new ArrayList<>();

        ints.add(10);
    }

    @Test
    public void testCache() {

        System.out.println("========char==========");
        Character c1 = 127;
        Character c2 = 127;
        Character c3 = 128;
        Character c4 = 128;
        System.out.println(c1 == c2);
        System.out.println(c3 == c4);

        System.out.println("========byte==========");
        Byte b1 = 127;
        Byte b2 = 127;
        Byte b3 = -128;
        Byte b4 = -128;
        System.out.println(b1 == b2);
        System.out.println(b3 == b4);

        System.out.println("========short==========");
        Short s1 = 127;
        Short s2 = 127;
        Short s3 = -129;
        Short s4 = -129;
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);

        System.out.println("========int==========");
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = -129;
        Integer i4 = -129;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        System.out.println("========long==========");
        Long l1 = 127L;
        Long l2 = 127L;
        Long l3 = -129L;
        Long l4 = -129L;
        System.out.println(l1 == l2);
        System.out.println(l3 == l4);

        System.out.println("========Boolean==========");
        Boolean bb1 = false;
        Boolean bb2 = false;
        System.out.println(bb1 == bb2);
    }


    @Test
    public void testCache2() throws NoSuchFieldException, IllegalAccessException {
        Integer i1 = new Integer(128);
        Integer i2 = 128;
        System.out.println(i1 == i2);
        System.out.println("equals方法：" + i1.equals(i2));

    }
}
