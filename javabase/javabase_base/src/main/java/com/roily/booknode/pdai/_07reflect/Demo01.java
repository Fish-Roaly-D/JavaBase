package com.roily.booknode.pdai._07reflect;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

/**
 * @classname：Demo01
 * @author: rolyfish
 * @description:
 * @date: 2022/11/3 19:57
 */
public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        final Class<?> aClass = Class.forName("");

        final Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
    }

    @Test
    public void test() {
        //普通类
        System.out.println(Class1.class.getSimpleName());
        System.out.println(Class1.class.getName());
        System.out.println(Class1.class.getCanonicalName());
        //内部类
        System.out.println(Class1.Class2.class.getSimpleName());
        System.out.println(Class1.Class2.class.getName());
        System.out.println(Class1.Class2.class.getCanonicalName());
        //数组
        final Object o = Array.newInstance(String.class, 1);
        System.out.println(o.getClass().getSimpleName());
        System.out.println(o.getClass().getName());
        System.out.println(o.getClass().getCanonicalName());
    }
}

class Class1{
    class Class2{
    }
}