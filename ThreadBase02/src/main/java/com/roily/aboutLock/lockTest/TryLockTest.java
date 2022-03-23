package com.roily.aboutLock.lockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName TryLockTest.java
 * @author: RoilyFish
 * @date: 2022/3/23 17:40
 */
public class TryLockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            //获取锁成功
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + "线程获取锁成功，开始做事");
                int i = 10;
                while (i-- > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //获取锁失败
            else {
                System.out.println(Thread.currentThread().getName() + "线程获取锁失败，做其他事");

            }
        });
        Thread t2 = new Thread(() -> {
            //获取锁成功
            if (lock.tryLock()) {

                System.out.println(Thread.currentThread().getName() + "线程获取锁成功，开始做事");

            } else {
                System.out.println(Thread.currentThread().getName() + "线程获取锁失败，做其他事");
            }

        });

        t1.start();
        Thread.sleep(500);
        t2.start();
        //保证非main线程运行成功
        Thread.sleep(500);

    }


}

class TryLockTest2 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            //获取锁成功
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "线程获取锁成功，开始做事");
                    int i = 10;
                    while (i-- > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }finally {
                    System.out.println(Thread.currentThread().getName() + "线程释放锁");
                    lock.unlock();
                }
            }
            //获取锁失败
            else {
                System.out.println(Thread.currentThread().getName() + "线程获取锁失败，做其他事");
            }
        });
        Thread t2 = new Thread(() -> {
            //一直等待成功获取锁
            while (!lock.tryLock()) System.out.println("等待获取锁");
            try {
                //获取锁成功
                System.out.println(Thread.currentThread().getName() + "线程获取锁成功，开始做事");
            }finally {
                System.out.println(Thread.currentThread().getName() + "线程释放锁");
                lock.unlock();
            }
        });
        t1.start();
        Thread.sleep(500);

        t2.start();
        //保证非main线程运行成功
        Thread.sleep(500);

    }
}
class TryLockTest3 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            //获取锁成功
            try {
                if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "线程获取锁成功，开始做事");
                        int i = 10;
                        while (i-- > 0) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }finally {
                        System.out.println(Thread.currentThread().getName() + "线程释放锁");
                        lock.unlock();
                    }
                }
                //获取锁失败
                else {
                    System.out.println(Thread.currentThread().getName() + "线程获取锁失败，做其他事");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            //获取锁成功
            try {
                if (lock.tryLock(200, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "线程获取锁成功，开始做事");
                        int i = 10;
                        while (i-- > 0) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }finally {
                        System.out.println(Thread.currentThread().getName() + "线程释放锁");
                        lock.unlock();
                    }
                }
                //获取锁失败
                else {
                    System.out.println(Thread.currentThread().getName() + "线程获取锁失败，做其他事");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(500);

        t2.start();
        //保证非main线程运行成功
        Thread.sleep(500);

    }
}
