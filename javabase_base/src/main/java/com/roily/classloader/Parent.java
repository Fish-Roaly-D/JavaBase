package com.roily.classloader;

/**
 * @classname：Parent
 * @author: rolyfish
 * @description:
 * @date: 2022/7/26 00:38
 */
public class Parent {
    static int a = 1;
    static {
        ++a;
    }
}

class Son extends Parent {
    private static int b = a;
    public static void main(String[] args) {
        System.out.println(Son.b);
    }
}