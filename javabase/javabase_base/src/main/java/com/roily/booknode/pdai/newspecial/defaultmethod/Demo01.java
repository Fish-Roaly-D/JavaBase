package com.roily.booknode.pdai.newspecial.defaultmethod;

/**
 * @classname：Demo01
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/6 20:34
 */
public class Demo01 {


}


interface IDemo {
    default void m1() {
        System.out.println("默认方法");
    }
}

class IDemoImpl implements IDemo {
    public static void main(String[] args) {
        final IDemo iDemo = new IDemoImpl();
        iDemo.m1();
    }
}

