package com.roily.aboutLock.lockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName LockTest.java
 * @author: RoilyFish
 * @date: 2022/3/23 15:47
 */
public class LockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "线程尝试获取可响应中断锁");

            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "执行");
                int i = 10;
                while (i-- > 0) Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            } finally {
                //lock必须手动释放
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
        });

        Thread t2 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "线程尝试获取可响应中断锁");

            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "执行");
            } catch (InterruptedException e) {
                //响应中断线程
                System.out.println(Thread.currentThread().getName() + "被中断");
            } finally {
                //处理异常  如果线程没有获取锁而手动关闭的化  会抛出异常
                try {
                    //lock必须手动释放
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                } catch (Exception e) {
                    System.out.println("被中断的线程：" + Thread.currentThread().getName() + "运行结束");
                }
            }
        });

        t1.start();
        //睡一会  t1先执行
        Thread.sleep(100);
        t2.start();
        //中断线程2  如果不中断 和lock是一样的
        t2.interrupt();
    }
}

class LockTest2 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "线程尝试获取可响应中断锁");

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "执行");
                int i = 10;
                while (i-- > 0) Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            } finally {
                //lock必须手动释放
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
        });

        Thread t2 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "线程尝试获取可响应中断锁");

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "执行");
            } catch (Exception e) {
                //响应中断线程
                System.out.println(Thread.currentThread().getName() + "被中断");
            } finally {
                //处理异常  如果线程没有获取锁而手动关闭的化  会抛出异常
                try {
                    //lock必须手动释放
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                } catch (Exception e) {
                    System.out.println("被中断的线程：" + Thread.currentThread().getName() + "运行结束");
                }
            }
        });

        t1.start();
        //睡一会  t1先执行
        Thread.sleep(100);
        t2.start();
        //使用lock()获取锁  是中断不了的
        t2.interrupt();

        System.out.println(t2.isInterrupted());
    }
}

