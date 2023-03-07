package com.roily.thread_02;

import java.util.concurrent.CountDownLatch;

/**
 * descripte: Thread.join()
 *
 *      作用：使用wait()当前线程交出时间片，进入等待， 调用此方法的线程抢占时间片先执行
 *
 *  可以使得线程按顺序执行
 *
 * @author: RoilyFish
 * @date: 2022/3/13
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(10);
        System.out.println(Thread.currentThread().getName() + "执行执行");
        //之前线程
        Thread previousThread = Thread.currentThread();
        while (latch.getCount() > 0) {
            //当前线程
            MyThread currentThread = new MyThread(previousThread,latch.getCount());
            currentThread.start();
            previousThread = currentThread;
            latch.countDown();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + "执行结束");
    }
}

class MyThread extends Thread {
    Long i;
    //需要Join的线程
    private Thread thread;

    public MyThread(Thread joinThread,Long i) {
        this.thread = joinThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            thread.join();
            System.out.println(Thread.currentThread().getName() +"  "+ i +":执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class JoinDemo2 {
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
        t2.start();
        t2.join();
        t3.join();
        t3.start();
    }
}