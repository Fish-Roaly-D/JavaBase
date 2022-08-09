package com.roily.booknode.javatogod._02coll;

import com.google.common.base.Function;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Date: 2022/08/09/11:20
 * @Description:
 */
public class AboutStream {


    @Test
    public void test1() {
        System.out.println("===============流  转集合===============");
        List<String> list = new ArrayList<>(Arrays.asList("1","1", "2", "3", "4", "5", "6", "7", "8", "9"));
        List<String> collect1 = list.stream().collect(Collectors.toList());
        collect1.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============遍历===============");
        list.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============过滤===============");
        List<String> collect2 = list.stream().filter((ele) -> ele.equals("2")).collect(Collectors.toList());
        collect2.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============映射===============");
        List<Integer> collect3 = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        collect3.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============求和 求平均值===============");
        int sum = list.stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

        System.out.println("===============求和 求平均值===============");
//        Object collect = list.stream().mapToInt(Integer::valueOf).collect(Collectors., null, null);
//        System.out.println(collect);

        System.out.println("===============去重===============");
        List<String> collect4 = list.stream().distinct().collect(Collectors.toList());
        collect4.stream().forEach(System.out::print);
        System.out.println();

    }

    @Test
    public void test2() {


    }

    @Test
    public void test3() {


    }


}
