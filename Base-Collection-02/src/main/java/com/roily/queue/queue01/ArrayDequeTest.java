package com.roily.queue.queue01;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ArrayDequeTest.java
 * @author: RoilyFish
 * @date: 2022/4/28 23:36
 */
public class ArrayDequeTest {



    @Test
    public void test(){

        //默认16
        ArrayDeque<String> strings = new ArrayDeque<>();

        strings.addFirst("abc");

        // 1000 0000 0000 0000 0000 0000
        // 0000                     1111
        System.out.println( (-1) & 15);
    }

    @Test
    public void getFirst(){

        //默认16
        ArrayDeque<String> strings = new ArrayDeque<>();

        strings.addFirst("1");
        strings.addFirst("2");
        strings.addFirst("3");
        strings.addFirst("4");

        System.out.println(strings.element());
        System.out.println(strings.getFirst());
        //System.out.println(strings.getLast());
        //System.out.println(strings.pop());
    }

    @Test
    public void getLaset(){

        //默认16
        ArrayDeque<String> strings = new ArrayDeque<>();

        strings.addFirst("1");
        strings.addFirst("2");
        strings.addFirst("3");
        strings.addFirst("4");

        strings.addLast("5");

        System.out.println(strings.getLast());
        System.out.println(strings.pop());
        System.out.println(strings.poll());
        System.out.println(strings.pollFirst());
        System.out.println(strings.pollLast());

    }


    @Test
    public void testArraycopy(){

        String[] strs = new String[10];

        strs[0] = "0";
        strs[1] = "1";
        strs[2] = "2";
        strs[7] = "7";
        strs[8] = "8";
        strs[9] = "9";

        Arrays.stream(strs).forEach((str)->{
            System.out.printf(str+",");
        });

        System.out.println();
        String[] strs2 = new String[20];

        //将strs  拷贝到 strs2里
        System.arraycopy(strs,0,strs2,0,10);

        Arrays.stream(strs2).forEach((str)->{
            System.out.printf(str+",");
        });

    }


    @Test
    public void remove(){

        //默认16
        ArrayDeque<String> strings = new ArrayDeque<>();

        strings.addFirst("1");
        strings.addFirst("1");
        strings.addFirst("2");
        strings.addFirst("3");
        strings.addFirst("4");
        strings.addFirst("1");

        strings.addLast("5");

        System.err.println(strings.size());

        //strings.removeFirstOccurrence("1");
        strings.removeLastOccurrence("1");

        strings.stream().forEach((obj)->{
            System.out.println(obj);
        });

    }
}
