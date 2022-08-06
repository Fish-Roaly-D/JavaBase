package com.roily.jvm.day02;

/**
 * @classname：Parent
 * @author: rolyfish
 * @description:
 * @date: 2022/8/6 22:01
 */
public class Parent {

    void parentMethod() {
        System.out.println("parentMethod");
    }
}

class Son extends Parent {

    @Override
    void parentMethod() {
        System.out.println("SonMethod");
    }
}

class SonSon extends Son {
    void sonSonMethod() {
        super.parentMethod();
        System.out.println();
    }

    public static void main(String[] args) {
        final SonSon sonSon = new SonSon();
        sonSon.sonSonMethod();
    }
}