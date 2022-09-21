package com.roily.booknode.javatogod._07Annotation.a01;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Date: 2022/08/30/20:00
 * @Description:
 */
public class TestDeprecated {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        MyDeprecatedAnnotation.method();
        // MyDeprecatedAnnotation.value;
    }
}

class TestSafeVarargs<T> {

    @SafeVarargs
    public final TestSafeVarargs<T> method(T... values) {
       
        return null;
    }

}