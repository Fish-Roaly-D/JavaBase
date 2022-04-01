package com.roily.aboutLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName LockDemo01.java
 * @author: RoilyFish
 * @date: 2022/3/21 18:20
 */
public class LockDemo01 {

    private static int a = 0;

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    for (int i1 = 0; i1 < 10000; i1++) {
                        a++;
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }).start();
        }

        Thread.sleep(2000);

        System.out.println(a);
    }


}

class lockdemo02{

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        new Thread(()->{
            try {
                lock.lock();
                //死循环  阻止其他线程获取锁
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "已经获取锁，执行业务");
                System.out.println(Thread.currentThread().isInterrupted());
            }finally {
                System.out.println(Thread.currentThread().getName() + "执行final代码块");

                lock.unlock();
            }
        });

        thread.start();

        //睡一会
        Thread.sleep(500);

        //中断线程2
        System.err.println("中断"+thread.getName());
        thread.interrupt();

        System.out.println(thread.isInterrupted());

    }
}

class lockdemo03{

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        new Thread(()->{
            try {
                lock.lock();
                //死循环  阻止其他线程获取锁
                while (true);
            } finally {
                lock.unlock();
            }
        }).start();

        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "已经获取锁，执行业务");
            }catch (Exception e){
                System.out.println("exe");
            } finally {
                System.out.println(Thread.currentThread().getName() + "执行final代码块");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "已经获取锁，执行业务");
            }catch (Exception e){
                System.out.println("exe");
            } finally {
                System.out.println(Thread.currentThread().getName() + "执行final代码块");
            }
        });

        thread.start();
        thread2.start();
        //睡一会
        Thread.sleep(500);

        //中断线程2
        System.err.println("中断"+thread2.getName());
        thread.interrupt();

    }
}