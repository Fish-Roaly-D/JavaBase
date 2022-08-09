package com.roily.booknode.javatogod._02coll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * @Date: 2022/08/09/11:20
 * @Description:
 */
public class AboutIterable {


    @Test
    public void test1() {

        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

        list.forEach(System.out::print);
        System.out.println("        foreach");

        Spliterator<String> spliterator = list.spliterator().trySplit();
        spliterator.forEachRemaining(System.out::print);
        System.out.println("        spliterator   forEachRemaining");

        Spliterator<String> spliterator1 = list.spliterator();
        while (spliterator1.tryAdvance(System.out::print)) ;
        System.out.println("         spliterator   tryAdvance");
    }

    @Test
    public void test2() {

        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

        Spliterator<String> spliterator = list.spliterator();

        Spliterator<String> spliterator1 = spliterator.trySplit();
        spliterator1.forEachRemaining(System.out::print);
        System.out.println("        spliterator1   forEachRemaining");
        Spliterator<String> spliterator2 = spliterator.trySplit();
        spliterator2.forEachRemaining(System.out::print);
        System.out.println("        spliterator2   forEachRemaining");

    }

    @Test
    public void test3() {

        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

        Spliterator<String> spliterator = list.spliterator();

        Spliterator<String> spliteratorTemp = null;
        while (null != (spliteratorTemp = spliterator.trySplit())) {
            spliteratorTemp.forEachRemaining(System.out::print);
            System.out.println();
        }
        spliterator.forEachRemaining(System.out::print);
    }


}
