package com.roily.booknode.pdai._07reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @classname：ClassField
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/6 20:00
 */
public class ClassField {


    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {

        final ClassFieldDemo classFieldDemo = new ClassFieldDemo();

        final Field value = ClassFieldDemo.class.getField("value");

        value.set(classFieldDemo,"value");

        System.out.println(classFieldDemo);


        System.out.println((char)46);
    }

}


class ClassFieldDemo{

    public String value;

    @Override
    public String toString() {
        return "ClassFieldDemo{" +
                "value='" + value + '\'' +
                '}';
    }
}