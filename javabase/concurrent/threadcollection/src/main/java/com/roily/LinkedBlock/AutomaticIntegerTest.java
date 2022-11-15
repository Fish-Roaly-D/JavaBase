package com.roily.LinkedBlock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName AutomaticIntegerTest.java
 * @author: RoilyFish
 * @date: 2022/5/5 0:20
 */
public class AutomaticIntegerTest {


    Integer value = 0;

    @Test
    public void testSimpleType() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    value++;
                }
            }).start();
        }
        Thread.sleep(2000);

        System.out.println(value);
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);
    @Test
    public void testAtomaicType() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    atomicInteger.getAndIncrement();
                }
            }).start();
        }
        Thread.sleep(2000);

        System.out.println(atomicInteger.get());
    }


}
