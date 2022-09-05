package com.roily.booknode.javatogod._09sugar;

import com.roily.booknode.javatogod._02coll.FailFast;

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
        Comparator<String> c = (v1,v2)->{
          return   v1.compareTo(v2);
        };
    }
    public void method2() {

        final List<Integer> integers = Arrays.asList(1, 2, 3);

        final List<String> collect = integers.stream().map(String::valueOf).collect(Collectors.toList());

    }

}
