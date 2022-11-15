package com.roily.booknode.pdai._07reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @classname：ClassConstructor
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/4 13:14
 */
public class ClassConstructor {


    @Test
    public void test1() throws NoSuchMethodException {

        final Constructor<ClassConstructor> constructor = ClassConstructor.class.getConstructor();

        System.out.println(constructor.getDeclaringClass());



    }
}
