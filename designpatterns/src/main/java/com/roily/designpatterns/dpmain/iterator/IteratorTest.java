package com.roily.designpatterns.dpmain.iterator;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @className：IteratorTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 22:56
 */
public class IteratorTest {

    @Test
    public void test() {

        final ArrayList<String> strings = new ArrayList<>();

        strings.get(1);
    }


    @Test
    public void testMyCollection() {

        MyCollection<Integer> objectMyCollection = new MyCollection<>();

        Iiterator<Integer> iterator = objectMyCollection.iterator();

        while (iterator.hashNext()){
            System.out.println(iterator.next());
        }

    }
}
