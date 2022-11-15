package com.roily.base.jvm.classloader;

/**
 * @classname：IParent
 * @author: rolyfish
 * @description: todo
 * @date: 2022/7/26 00:48
 */
public interface IParent {
    public static int b = 2;

}

interface ISon extends IParent {
    public static int a = 1;
}

class Client {
    public static void main(String[] args) {
        final int a = ISon.a;
        System.out.println(ISon.a);
    }
}