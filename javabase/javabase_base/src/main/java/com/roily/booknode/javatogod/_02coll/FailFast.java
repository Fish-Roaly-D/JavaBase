package com.roily.booknode.javatogod._02coll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @classname：FailFast
 * @author: rolyfish
 * @description:
 * @date: 2022/8/21 17:38
 */
public class FailFast {

    @Test
    public void test1() {
        final List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            list.remove("1");
            list.add("1");
            iterator.next();
        }
    }

    @Test
    public void test2() {
        final List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        for (String s : list) {
            list.add("a");
        }
    }

    @Test
    public void test3() {
        final List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        final ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if ("3".equals(listIterator.next()))
                listIterator.add("add");
        }
        System.out.println(list);
    }

}
