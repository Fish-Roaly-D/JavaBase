package com.roily.booknode.javatogod._09sugar;

import com.roily.booknode.javatogod._02coll.FailFast;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date: 2022/09/05/14:16
 * @Description:
 */
public class TestLambda {

    public void method1() {
        Comparator<String> c = (v1, v2) -> {
            return v1.compareTo(v2);
        };
    }

    public void method2() {

        final List<Integer> integers = Arrays.asList(1, 2, 3);

        final List<String> collect = integers.stream().map(String::valueOf).collect(Collectors.toList());
    }


    @Test
    public void testLambda() {

        Demo1 demo1 = () -> {
        };

        Demo2 demo2 = () -> {
            return "123";
        };
        //只有一个参数，括号可以省略
        Demo3 demo3 = value -> {
            return String.valueOf(value);
        };
        //有多个参数，括号不可以省略
        Demo4 demo4 = (value1, value2) -> {
            return String.valueOf(value1 + value2);
        };
    }

}

interface Demo1 {
    /**
     * 没有参数，返回值为null
     */
    void method();
}

interface Demo2 {
    /**
     * 没有参数，返回值为String类型
     */
    String method();
}

interface Demo3 {

    String method(int value);
}

interface Demo4 {

    String method(int value1, int value2);
}

