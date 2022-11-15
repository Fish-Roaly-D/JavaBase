package com.roily.LinkedBlock;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Description
 * @ClassName IntMaxTest.java
 * @author: RoilyFish
 * @date: 2022/5/4 15:51
 */
public class IntMaxTest {



    @Test
    public void testIntMax(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void testAutomaticInt(){

        AtomicInteger atomicInteger = new AtomicInteger(10);

        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.getAndDecrement());

        System.out.println(atomicInteger.get());

    }

    @Test
    public void testPeek() throws InterruptedException {

        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();

        Thread addT = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add("");
        });

        Thread peekT = new Thread(() -> {
            Object peek = queue.peek();
            System.out.println(peek);
        });

        addT.start();

        peekT.start();

        Thread.sleep(2000);

    }



}
