package com.roily.booknode.javatogod._11thread;

import org.junit.Test;

/**
 * @Date: 2022/09/09/15:42
 * @Description:
 */
public class ThreadPriority {

    @Test
    public void test() {

        System.out.println(Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(7);

        System.out.println(Thread.currentThread().getPriority());

    }

    @Test
    public void test2() {
        final MyThread myThread1 = new MyThread();
        final MyThread myThread2 = new MyThread();
        final MyThread myThread3 = new MyThread();

        final Thread thread1 = new Thread(myThread1);
        final Thread thread2 = new Thread(myThread2);
        final Thread thread3 = new Thread(myThread3);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        final MyThread myThread1 = new MyThread();
        final MyThread myThread2 = new MyThread();
        final MyThread myThread3 = new MyThread();

        final Thread thread1 = new Thread(myThread1);
        final Thread thread2 = new Thread(myThread2);
        final Thread thread3 = new Thread(myThread3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}
