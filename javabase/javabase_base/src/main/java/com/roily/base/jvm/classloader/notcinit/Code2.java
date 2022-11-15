package com.roily.base.jvm.classloader.notcinit;

/**
 * @classname：Code2
 * @author: rolyfish
 * @description:
 * @date: 2022/7/26 01:17
 */
public class Code2 {

    public static void main(String[] args) {
        System.out.println(Demo.a);
        System.out.println(Demo2.str);
    }
}

class Demo {
    final static int a = 1;
    static {
        System.out.println("Demo初始化");
    }
}

class Help {
    static String a = "abc";
}

class Demo2 {
    /**
     * 不是字面量，会触发类的初始化
     */
    final static String str = Help.a;
    static {
        System.out.println("Demo2初始化");
    }
}