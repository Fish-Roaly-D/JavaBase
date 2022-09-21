package com.roily.booknode.javatogod._02coll;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Date: 2022/08/10/17:34
 * @Description:
 */
public class AboutSynChronizedList {

    @Test
    public void test1() {
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.rotate(integers, 5);
        integers.stream().forEach(System.out::print);

        List<Object> objects = Collections.emptyList();
        objects.add("");
    }

    @Test
    public void test2() {
        Set<String> singleton = Collections.singleton("");

        singleton.add("1");
    }


    @Test
    public void test3() {
        List<String> list = Collections.nCopies(10, "abc");
//        list.add("1");

        list.forEach(System.out::println);
    }


    @Test
    public void test4() {

        List<String> list = Arrays.asList("a", "a", "a", "a", "123", "123");
        int count = Collections.frequency(list, "a");
        System.out.println(count);

    }

    @Test
    public void test5() {

        List<String> listSource = Arrays.asList("a", "b", "a", "b", "c", "123");
        List<String> listTarget = Arrays.asList("a", "b", "c");

        int index = Collections.indexOfSubList(listSource, listTarget);
        int lastIndex = Collections.lastIndexOfSubList(listSource, listTarget);
        System.out.println(index);
        System.out.println(lastIndex);
    }

    @Test
    public void test6() {

        List<String> listSource = Arrays.asList("a", "b", "a", "b", "c", "123");


        List<String> listTarget = Arrays.asList("", "", "", "", "", "","a");

        Collections.copy(listTarget, listSource);

        listTarget.forEach(System.out::println);

    }

}
