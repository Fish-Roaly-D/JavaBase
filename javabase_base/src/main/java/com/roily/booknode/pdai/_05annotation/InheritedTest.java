package com.roily.booknode.pdai._05annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @classname：InheritedTest
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/31 23:33
 */
public class InheritedTest {
}


@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface InheritedTestI {
    String value();
}

@InheritedTestI(value = "父类注解")
class Parent {
}

class Son extends Parent {
    public static void main(String[] args) {
        final Annotation[] declaredAnnotations = Son.class.getAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            if (declaredAnnotation instanceof InheritedTestI) {
                System.out.println(((InheritedTestI) declaredAnnotation).value());
            }
        }
    }
}

