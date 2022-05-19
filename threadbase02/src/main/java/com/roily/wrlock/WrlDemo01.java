package com.roily.wrlock;

import org.junit.Test;

import java.util.concurrent.locks.*;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName WrlDemo01.java
 * @author: RoilyFish
 * @date: 2022/3/28 22:47
 */
public class WrlDemo01 {

    //模拟读锁被获取，其他锁阻塞
    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();


        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
                //当前线程获取读锁  其他线程阻塞
                writeLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了写锁");
                System.out.println("睡5秒 在此过程其他线程阻塞");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放写锁");

                writeLock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
                //当前线程阻塞
                writeLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了写锁");
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放写锁");

                writeLock.unlock();
            }
        }).start();


    }


}

class WrlDemo02 {

    //模拟读锁被获取，其他锁阻塞
    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();


        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
                //当前线程获取读锁  其他线程阻塞
                writeLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了写锁");
                System.out.println("睡5秒 在此过程其他线程阻塞");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放写锁");

                writeLock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
                //当前线程阻塞
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放读锁");

                readLock.unlock();
            }
        }).start();


    }


}

class WrlDemo03 {


    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();


        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
                //当前线程获取读锁
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
                Thread.sleep(5000);
                System.out.println("睡5秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放读锁");

                readLock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
                //当前线程阻塞
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放读锁");
                readLock.unlock();
            }
        }).start();


    }


}

class WrlDemo04 {


    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();


        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
                //当前线程获取读锁
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
                Thread.sleep(5000);
                System.out.println("睡5秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放读锁");

                readLock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
                writeLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了写锁");
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放写锁");
                writeLock.unlock();
            }
        }).start();


    }


}

class Runable01 implements Runnable {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    //共享数据
    private static int count = 0;


    @Override
    public void run() {
        try {
            System.out.println("尝试获取写锁");
            writeLock.lock();
            System.out.println("获取了写锁");
            System.out.println("业务操作");

            do Thread.sleep(500); while (++count < 10);
            try {
                System.out.println("尝试获取读锁");
                readLock.lock();
                System.out.println("获取了读锁");
                System.out.println("读取共享变量" + "count:" + count);
            } finally {
                //释放写锁
                writeLock.unlock();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

        new Thread(new Runable01()).start();

    }
}

class readHoldsTest{

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();


    public static void main(String[] args) {


        new Thread(()-> {

            readLock.lock();
            //获取读锁死循环  模拟占用firstReader
            while (true);

        }).start();

        new Thread(()-> {

            try {
                readLock.lock();
                //第二次获取读锁
                System.out.println("第二次获取读锁");
            }finally {
                System.out.println("释放读锁");
                readLock.unlock();
            }

            int i = 0;

            try {
                readLock.lock();
                //释放锁后再次获取
                System.out.println("释放锁后再次获取");
            }finally {
                System.out.println("释放读锁");
                readLock.unlock();
            }
        }).start();


    }


}

class xxxx extends AbstractQueuedSynchronizer{

}