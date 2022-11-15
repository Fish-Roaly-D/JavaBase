package com.roily.booknode.javatogod._07Annotation.a01;

import java.lang.annotation.Annotation;

/**
 * @Date: 2022/08/30/13:34
 * @Description:
 */
@MyDefinitionAnnotation
public class MyTestClass {
    @MyDefinitionAnnotation
    String value;

    @MyDefinitionAnnotation
    public void method1() {

    }

    public static void main(String[] args) {
        final Annotation[] annotations = MyTestClass.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }
}
