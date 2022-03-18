package com.roily.thread_02;

import org.junit.Test;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/13
 */
public class joinDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"执行执行");

        //之前线程
        Thread previousThread = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            //当前线程
            MyThread currentThread = new MyThread(previousThread);
            currentThread.start();
            previousThread = currentThread;
        }

        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName()+"执行结束");
    }
}

class MyThread extends Thread {
    //需要Join的线程
    private Thread thread;

    public MyThread(Thread joinThread) {
        this.thread = joinThread;
    }

    @Override
    public void run() {
        try {
            thread.join();
            System.out.println(Thread.currentThread().getName() + "执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}

class xxdemo{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("t1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> System.out.println("t2"));

        Thread t3 = new Thread(() -> {
            System.out.println("t3");
        });

        t1.start();
        t1.join();
        t2.start();
        t3.start();
    }
}