package com.roily.booknode.pdai._05annotation.deep;

import java.lang.annotation.Annotation;

/**
 * @Date: 2022/11/01/11:16
 * @Description:
 */
@MyAnnotation(value = "value")
public class Test1 {

    public static void main(String[] args) {

        final MyAnnotation declaredAnnotation = Test1.class.getDeclaredAnnotation(MyAnnotation.class);
        final String value = declaredAnnotation.value();
        System.out.println(value);

    }
}
