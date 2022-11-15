package com.roily.aboutLock.lockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ConditionTest.java
 * @author: RoilyFish
 * @date: 2022/3/23 18:08
 */
public class ConditionTest {
    //lock
    private static ReentrantLock lock = new ReentrantLock();
    //condition
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程等待");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");
                System.out.println(Thread.currentThread().getName() + "唤醒该condition上的等待线程");
                condition.signal();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        //t1先启动
        //Thread.sleep(5);
        t2.start();
        //保证非main线程执行
        Thread.sleep(1000);
    }
}
class ConditionTestx {
    //lock
    private static ReentrantLock lock = new ReentrantLock();
    //condition
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程等待");
                //等待指定时间  并且重新获取锁，如果锁被其他线程占有，则继续等待
                condition.await(1000, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "唤醒该condition上的等待线程");
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        //t1先启动
        Thread.sleep(5);
        //t2.start();
        //保证非main线程执行
        Thread.sleep(1000);
    }
}

class ConditionTest2 {
    //lock
    private static ReentrantLock lock = new ReentrantLock();
    //condition
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程等待");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程等待");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t22 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程等待");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t222 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程等待");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                //调用condition的await()方法前需要首先获取锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");

                System.out.println(Thread.currentThread().getName() + "唤醒该condition上的等待线程");
                condition.signal();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        //t1先启动
        Thread.sleep(5);
        t2.start();
        Thread.sleep(5);
        t22.start();
        Thread.sleep(5);
        t222.start();
        Thread.sleep(5);
        t3.start();
        //保证非main线程执行
        Thread.sleep(1000);
    }
}

class ObjectWaitAndThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        ObjectWaitAndThreadSleep objectWaitAndThreadSleep = new ObjectWaitAndThreadSleep();

        objectWaitAndThreadSleep.ObjectWait();
    }

    public void ObjectWait() throws InterruptedException {
        //监视器
        Object o = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");
                try {
                    System.out.println(Thread.currentThread().getName() + "线程等待");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            }
        });

        Thread t11 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");
                try {
                    System.out.println(Thread.currentThread().getName() + "线程等待");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            }
        });
        Thread t111 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");
                try {
                    System.out.println(Thread.currentThread().getName() + "线程等待");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，继续执行");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "尝试线程获取锁");
                System.out.println(Thread.currentThread().getName() + "线程已经获取了锁");
                System.out.println(Thread.currentThread().getName() + "线程开始执行业务");

                System.out.println(Thread.currentThread().getName() + "唤醒其他线程");
                o.notify();
            }
        });
        t1.start();
        //Thread.sleep(5);
        //t11.start();
        //Thread.sleep(5);
        //t111.start();
        //Thread.sleep(5);
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(500);
    }
}