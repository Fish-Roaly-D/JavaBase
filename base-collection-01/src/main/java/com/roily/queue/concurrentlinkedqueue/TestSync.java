package com.roily.queue.concurrentlinkedqueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Description
 * @ClassName TestSync.java
 * @author: RoilyFish
 * @date: 2022/5/16 19:32
 */
public class TestSync {


    AtomicInteger value = new AtomicInteger(0);
    //测试线程安全的变量，其引用是否可以感知
    //可以感知，指向同一个对象
    @Test
    public void test() {

        new Thread(() -> {
            for (AtomicInteger p = value, q = p;;){
                while (q.get() <=1000000){
                    System.out.println(p.get());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


        for (int i = 2; i > 0; i--) {
            new Thread(() -> {
                while (true) {
                    value.incrementAndGet();
                }
            }).start();
        }
        while (true) ;
    }

}
