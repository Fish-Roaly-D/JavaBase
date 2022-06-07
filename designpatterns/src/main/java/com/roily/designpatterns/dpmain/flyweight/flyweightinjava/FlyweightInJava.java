package com.roily.designpatterns.dpmain.flyweight.flyweightinjava;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description java中的享元模式
 * @ClassName FlyweightInJava.java
 * @author: RoilyFish
 * @date: 2022/6/7 23:23
 */
public class FlyweightInJava {


    /**
     * 测试String的池化技术
     */
    @Test
    public void testString(){

        String str1 = "abc";
        String str2 = "123";
        String str3 = "abc";
        String str4 = new String("123");
        String str5 = new String("123");


        /**
         * true
         * str1 = “abc” jvm会检测字符串缓存池存不存在这个“abc”，不存在则创建一个 “abc”对象放入字符串缓存池
         * str3 = "abc" 检测到存在字符串“abc”，直接将str3引用指向缓存池中的“abc”
         */
        System.out.println(str1 == str3);
        /**
         * false
         * String str4 = new String("123"); str4会在堆内存创建一个String对象，堆内存的和缓存池的肯定不相等
         */
        System.out.println(str2 == str4);
        /**
         * false
         * new String("123") 在堆内存创建了一个新的字符串对象
         */
        System.out.println(str4 == str5);

    }


    /**
     * 以Integer为例
     */
    @Test
    public void testInteger(){

        Integer int1 = Integer.valueOf(1);
        Integer int2 = Integer.valueOf(1);
        Integer int3 = Integer.valueOf(-128);
        Integer int4 = Integer.valueOf(-128);
        Integer int5 = Integer.valueOf(127);
        Integer int6 = Integer.valueOf(127);

        Integer int7 = Integer.valueOf(128);
        Integer int8 = Integer.valueOf(128);
        Integer int9 = Integer.valueOf(-129);
        Integer int10 = Integer.valueOf(-129);

        //存在于缓存范围，返回true
        System.out.println(int1 == int2);
        System.out.println(int3 == int4);
        System.out.println(int5 == int6);

        //不存在于缓存范围，当作普通对象处理，返回false
        System.out.println(int7 == int8);
        System.out.println(int9 == int10);

    }
}
