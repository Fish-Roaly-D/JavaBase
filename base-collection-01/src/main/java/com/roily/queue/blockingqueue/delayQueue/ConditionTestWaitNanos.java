package com.roily.queue.blockingqueue.delayQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description 测试 超时等待是否自动唤醒
 * @ClassName ConditionTestWaitNanos.java
 * @author: RoilyFish
 * @date: 2022/5/6 0:36
 */
public class ConditionTestWaitNanos {

    /**
     * Condition.WaitNanos方法
     *
     * ①超时时间未过：线程处于TIMED_WAITING状态、可以被手动唤醒signal(),可跳过等待，竞争获取到锁，可继续执行
     * ①超时时间过了：线程处于WAITING状态、会自动唤醒，竞争获取到锁，可继续执行
     *
     * 对比wait方法，wait方法必须调用signal()才可以被唤醒，否则无休止等待
     */

    public static void main(String[] args) throws InterruptedException {

        //testWaitNanos();
        testWaitNanos2();
        //testWait();
    }

    //condition的WaitNanos方法
    //测试超时时间未过 等待线程的状态，是否可以被唤醒
    public static void testWaitNanos() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        final Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "=>获取锁");
            try {
                //等待100秒
                condition.awaitNanos(TimeUnit.MILLISECONDS.toNanos(100000));
                System.out.println(Thread.currentThread().getName() + "=>重新获取锁");
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
                /**
                 * 查看t1线程状态
                 * ①当线程超时时间未过，t1处于TIMED_WAITING状态
                 * ②当超过超时时间，t1未获取锁资源，t1处于WAITING状态
                 */
                //此刻线程超时时间未过  ①查看状态 ②是否可以手动唤醒
                System.out.println("线程" + t1.getName() + "处于：" + t1.getState().toString());
                condition.signal();
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

    //condition的WaitNanos方法
    //测试超时时间过了 未获取到锁资源，等待线程的状态，以及获取了锁资源是否自动唤醒
    public static void testWaitNanos2() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        final Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "=>获取锁");
            try {
                //等待6秒
                condition.awaitNanos(TimeUnit.MILLISECONDS.toNanos(5000));
                System.out.println(Thread.currentThread().getName() + "=>重新获取锁");
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
                //占用线程6秒钟
                Thread.sleep(6000);
                /**
                 * 查看t1线程状态
                 * ①当线程超时时间未过，t1处于TIMED_WAITING状态
                 * ②当超过超时时间，t1未获取锁资源，t1处于WAITING状态
                 */
                System.out.println("线程"+t1.getName()+"处于："+t1.getState().toString());

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
        Thread.sleep(1000);

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
