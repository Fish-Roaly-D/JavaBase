package com.roily.classloader.notcinit;

/**
 * @classname：Code1
 * @author: rolyfish
 * @description:
 * @date: 2022/7/26 01:15
 */
public class Code1 {
    public static void main(String[] args) {
        System.out.println(Son.a);
    }
}
class Parent {
    static int a = 1;
    static {
        System.out.println("父类初始化");
    }
}

class Son extends Parent {
    static {
        System.out.println("子类初始化");
    }
}