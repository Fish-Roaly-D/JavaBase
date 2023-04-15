package com.roily.aqsDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName AQSDemo.java
 * @author: RoilyFish
 * @date: 2022/3/24 22:12
 */
public class AQSDemo {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });

            thread.start();
        }

    }
}

class AQSDemo2 {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(2000);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });

            thread.start();
        }

    }
}

class AQSStatus {

    public static void main(String[] args) throws Exception {
        boolean flag = false;
        int a = 0;
        try {
            for (; ; ) {
                if (false) {
                    return;
                }
                if (a++ > 10) {
                    throw new Exception();
                }
            }
        } finally {
            System.out.println("XXXXXX");

        }

    }

}