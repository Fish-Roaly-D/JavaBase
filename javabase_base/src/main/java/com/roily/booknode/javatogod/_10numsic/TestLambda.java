package com.roily.booknode.javatogod._10numsic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @classname：TestLambda
 * @author: rolyfish
 * @description: todo
 * @date: 2022/9/6 01:37
 */
public class TestLambda {


    @Test
    public void test() {

        String str = "111";
        final List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        final List<Object> collect = integerList.stream().map(ele -> {

            System.out.println(str.length());
            //str = "123";
            return 1;
        }).collect(Collectors.toList());

        String first = "";
        Comparator<String> comparator = (first1, second) -> Integer.compare(first.length(), second.length());
        Comparator<String> x = (first1, second) -> Integer.compare(first.length(), second.length());
    }

}
