package com.roily.booknode.javatogod._02coll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author rolyfish
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
        while (spliterator1.tryAdvance(System.out::print)) {

        }
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

        Spliterator<String> spliteratorTemp;
        while (null != (spliteratorTemp = spliterator.trySplit())) {
            spliteratorTemp.forEachRemaining(System.out::print);
            System.out.println();
        }
        spliterator.forEachRemaining(System.out::print);
    }

    /**
     * CopyOnWriteIterator
     */
    @Test
    public void testCOW(){
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(Arrays.asList("1","2","3"));

        Iterator<String> iterator = cowList.iterator();
        //fail-sfae 集合修改
        for (String s : cowList) {
            if ("1".equals(s)){
                cowList.remove("3");
            }
            System.out.println(s);
        }
        //已经修改
        System.out.println(cowList);
        //但对迭代器不可见
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testxxx(){
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        for (String s : list) {
            if ("1".equals(s)){
                list.remove(s);
            }
            break;
        }
        System.out.println(list);
    }

}
