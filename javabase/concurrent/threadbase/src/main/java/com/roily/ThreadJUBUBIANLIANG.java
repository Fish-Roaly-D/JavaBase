package com.roily;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ThreadJUBUBIANLIANG.java
 * @author: RoilyFish
 * @date: 2022/5/3 19:52
 */
public class ThreadJUBUBIANLIANG {

    //方法参数为  传入参数的拷贝
    public void jubu(Integer value) {

        value++;

        System.out.println(Thread.currentThread() + "=>:" + value);

    }

    @Test
    public void test01() {

        Integer value = 0;

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                jubu(value);
            }).start();
        }

    }


    //AtomicInteger value = new AtomicInteger();
    Integer value = 0;

    //方法内创卷多个线程访问
    public void jubu2() throws InterruptedException {


        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                value++;
            }).start();
        }

        Thread.sleep(5000);

        System.out.println(value);
    }

    @Test
    public void test2() throws InterruptedException {

        jubu2();

    }

}
