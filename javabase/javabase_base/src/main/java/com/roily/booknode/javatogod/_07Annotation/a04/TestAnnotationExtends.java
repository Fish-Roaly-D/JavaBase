package com.roily.booknode.javatogod._07Annotation.a04;

import java.util.Arrays;

/**
 * @classname：TestAnnotationExtends
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/31 22:31
 */
public class TestAnnotationExtends {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(SonClass.class.getAnnotations()));
    }
}
