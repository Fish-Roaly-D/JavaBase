package com.roily.booknode.javatogod._01faceobj.extendsiscompile;

/**
 * @Date: 2022/07/29/13:23
 * @Description:
 * - 继承是一种编译期概念
 *
 * 编译期多态
 *  - 函数重载
 *
 * 运行期多态
 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> sonClass = Class.forName("com.roily.booknode.javatogod._01faceobj.extendsiscompile.Son");
        Person son = (Person) sonClass.newInstance();
        son.method1();
        Class<?> daughterClass = Class.forName("com.roily.booknode.javatogod._01faceobj.extendsiscompile.Daughter");
        Person daughter = (Person) daughterClass.newInstance();
        daughter.method1();
    }
}

class Person {

    void method1() {
        System.out.println("method1");
    }
}

class Son extends Person {

    @Override
    void method1() {
        System.out.println("son method01");
    }
}

class Daughter extends Person {

    @Override
    void method1() {
        System.out.println("Daughter method01");
    }
}