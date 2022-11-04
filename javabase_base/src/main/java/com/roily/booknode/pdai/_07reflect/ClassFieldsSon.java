package com.roily.booknode.pdai._07reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @classname：ClassFieldsParent
 * @author: rolyfish
 * @description:
 * @date: 2022/11/4 12:09
 */
public class ClassFieldsSon extends ClassFieldsParent {

    public String publicStrS;
    private String privateStrS;
    protected String protectedStrS;


    public void mPublicS() {

    }

    private void mPrivateS() {

    }

    protected void mProtectedS() {

    }

    @Test
    public void test() {
        System.out.println("========getFields=======");
        final Field[] fields = ClassFieldsSon.class.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("========getDeclaredFields=======");
        final Field[] declaredFields = ClassFieldsSon.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }

        System.out.println("========getMethods=======");
        final Method[] methods = ClassFieldsSon.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }System.out.println("========getDeclaredMethods=======");
        final Method[] declaredMethods = ClassFieldsSon.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

    }
}
