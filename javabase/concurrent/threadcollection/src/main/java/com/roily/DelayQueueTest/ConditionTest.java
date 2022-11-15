package com.roily.DelayQueueTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description 测试 超时等待是否自动唤醒
 * @ClassName ConditionTest.java
 * @author: RoilyFish
 * @date: 2022/5/6 0:36
 */
public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {

        testWaitNanos();
        //testWait();
    }

    //condition的WaitNanos方法
    public static void testWaitNanos() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        final Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "=>获取锁");
            try {
                //等待6秒
                condition.awaitNanos(TimeUnit.MILLISECONDS.toNanos(6000));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "=>线程被中断");
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "=>线程释放锁");
                lock.unlock();
            }

        }, "线程1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "=>获取锁");
            try {
                //占用线程1秒钟
                Thread.sleep(1000);
                /**
                 * 查看t1线程状态
                 * ①当线程超时时间未过，t1处于TIMED_WAITING状态
                 * ②当超过超时时间，t1位获取锁资源，t1处于WAITING状态
                 */
                System.out.println(t1.getState().toString());
                //尝试在超时间内是否可以唤醒，等待线程
                //可以不调用此方法，超时时间过了，t1线程会自动竞争获取锁
                condition.signal();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "=>线程被中断");
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "=>线程释放锁");
                lock.unlock();
            }

        }, "线程2");


        t1.start();
        //睡一下  t1先启动
        Thread.sleep(2000);

        t2.start();
    }

    //condition的wait方法
    public static void testWait() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        final Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "=>获取锁");
            try {
                condition.await();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "=>线程被中断");
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "=>线程释放锁");
                lock.unlock();
            }

        }, "线程1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "=>获取锁");
            try {
                //占用线程5秒钟
                Thread.sleep(5000);
                System.out.println(t1.getState().toString());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "=>线程被中断");
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "=>线程释放锁");

                System.out.println("唤醒等待线程");
                //必须在同步代码内调用此方法
                //必须调用此方法才可以唤醒等待线程
                condition.signal();
                lock.unlock();

            }

        }, "线程2");


        t1.start();
        //睡一下  t1先启动
        Thread.sleep(2000);

        t2.start();
    }

}
