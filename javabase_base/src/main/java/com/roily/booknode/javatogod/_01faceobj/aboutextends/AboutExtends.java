package com.roily.booknode.javatogod._01faceobj.aboutextends;

import org.junit.Test;

/**
 * @classname：AboutExtends
 * @author: rolyfish
 * @description:
 * @date: 2022/7/28 23:20
 */
public class AboutExtends {

    /**
     * 测试多实现
     */
    @Test
    public void test1() {
        InterfaceB classC1 = new ClassC();
        InterfaceA classC2 = new ClassC();
    }

    /**
     * 测试接口中的default方法
     */
    @Test
    public void test2() {

        ClassD classD1 = new ClassD();
        classD1.method1();
        //classD1.method2();
    }

}

/**
 * 对于类而言java目前只支持单继承
 */
class ClassA {


}

class ClassB extends ClassA {

}

/**
 * 但是java可以多实现，且java8之后接口中可以定义default方法
 */
interface InterfaceA {
    void method1();
}

interface InterfaceB {
    void method1();

    void method2();
}

class ClassC implements InterfaceA, InterfaceB {

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}

interface InterfaceC {
    default void method1() {
        System.out.println("InterfaceC default1方法");
    }
}

interface InterfaceD {
    default void method1() {
        System.out.println("InterfaceD default1方法");
    }
}

/**
 * 可以使用implement从多个接口中得到多个default方法，
 * 如果存在菱形问题，会强制要求实现类重写同名方法
 */
class ClassD implements InterfaceC, InterfaceD {

    @Override
    public void method1() {
        InterfaceC.super.method1();
    }
}