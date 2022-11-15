package com.roily.base.jvm.classloader.cinit;

/**
 * @classname：Code1
 * @author: rolyfish
 * @description:
 * @date: 2022/7/26 01:03
 */
public class Code1 {

    static int i = 1;

    static {
        i = 10;
        System.out.println("i的值为：" + i);
    }

}

class Test{

    static{
        System.out.println("main方法所在类初始化。。。");
    }

    public static void main(String[] args) {
        final Code1 code1 = new Code1();
    }

}