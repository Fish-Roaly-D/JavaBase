package com.roily.booknode.pdai._05annotation;

import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2022/10/31/14:44
 * @Description:
 */
public class Demo01 {

    @SafeVarargs // Not actually safe!
    final static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    public static void main(String[] args) {
        // m(Collections.EMPTY_LIST);
    }

    @SafeVarargs // Not actually safe!
    public Demo01(String ... strings) {

    }
}
