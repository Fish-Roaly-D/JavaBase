package com.roily.LinkedBlockingDequeTest;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @version 1.0.0
 * @Description
 * @ClassName TestAddAndGet.java
 * @author: RoilyFish
 * @date: 2022/5/5 17:36
 */
public class TestAddAndGet {


    @Test
    public void testAdd() throws InterruptedException {

        LinkedBlockingDeque<Object> deque = new LinkedBlockingDeque<>();

        deque.add(1);
        deque.addFirst(1);
        deque.addLast(1);

        deque.put(1);
        deque.putFirst(1);
        deque.putLast(1);

        deque.offer(1);

    }

    @Test
    public void testGet() throws InterruptedException {

        LinkedBlockingDeque<Object> deque = new LinkedBlockingDeque<>();

        for (int i = 0; i < 10; i++) {
            deque.add(i);
        }

        System.out.println(deque.getFirst());
        System.out.println(deque.peek());
    }


}
