package com.roily.LockSuportDemo;

import java.util.concurrent.locks.LockSupport;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName Demo01.java
 * @author: RoilyFish
 * @date: 2022/3/30 21:05
 */
public class Demo01 {


    public static void main(String[] args) {

        new Thread(() -> {
            //LockSupport.unpark(Thread.currentThread());
            LockSupport.park();
            System.out.println("a");

        }).start();

        new Thread(() -> {
            //LockSupport.unpark(Thread.currentThread());
            LockSupport.park("xxx");
            System.out.println("a");

        }).start();
    }

}

class Demo02 {


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            //线程一等待
            System.out.println(Thread.currentThread().getName() + "线程等待");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");

        });

        Thread t2 = new Thread(() -> {
            //线程而唤醒线程一

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "尝试唤醒" + t1.getName());
            LockSupport.unpark(t1);

        });

        t1.start();

        t2.start();

    }

}

class Demo03 {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            //线程一等待
            System.out.println(Thread.currentThread().getName() + "线程等待");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");

        });


        t1.start();

        //t1.interrupt();

        LockSupport.unpark(t1);

        System.out.println(t1.getState());

    }

}

class Demo04{

    public static void main(String[] args) {

        new Thread(()->{

            try {
                while (true){
                    LockSupport.park();
                }
            }finally {
                System.out.println("final");
            }


        }).start();




    }
}