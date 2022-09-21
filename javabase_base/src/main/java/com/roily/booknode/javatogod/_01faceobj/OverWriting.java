package com.roily.booknode.javatogod._01faceobj;

import java.util.ArrayList;

/**
 * @classname：OverWritting
 * @author: rolyfish
 * @description: 重写
 * @date: 2022/7/27 22:29
 */
public class OverWriting {
    public static void main(String[] args) {
        final Animal dog = new Dog();
        dog.bark();
    }
}

class Animal {
    void bark() {
        System.out.println("动物叫");
    }
}

class Dog extends Animal {
    @Override
    void bark() {
        System.out.println("狗叫");
    }
}

class Person {

    void method1(int a, int b) {
        System.out.println("XX");
    }

    ArrayList<Integer> method2() {
        return null;
    }

    void method3() throws IndexOutOfBoundsException {
    }

}

class Student extends Person {
    /**
     * 两同
     * - 方法名和参数列表相同
     */
    @Override
    void method1(int a, int b) {
        System.out.println("XX");
    }

    /**
     * 两小
     * - 返回参数要比被重写方法要小（范围）
     * - 抛出的异常范围要比父类小
     */
    //@Override
    //List<Integer> method2() {
    //    //通过不了编译
    //    return null;
    //}

    @Override
    void method3() throws RuntimeException {

    }

    public static void main(String[] args) {
        final Person student = new Student();
        student.method3();
    }
}

