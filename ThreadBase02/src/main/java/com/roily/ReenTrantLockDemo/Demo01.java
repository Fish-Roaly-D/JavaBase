package com.roily.ReenTrantLockDemo;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description 重入性
 * @ClassName Demo01.java
 * @author: RoilyFish
 * @date: 2022/3/26 22:01
 */
public class Demo01 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                lock.lock();
                lock.lock();
            } finally {

            }
        }).start();
    }

    @Test
    public void test(){

        System.out.println(65536>>>16);


    }
}

class SyncDemo01 {

    public static void main(String[] args) throws InterruptedException {

        //共享资源

        Object o = new Object();

        try {
            synchronized (o){

                System.out.println("首次获取锁，进入同步代码");

                synchronized (o){
                    System.out.println("再次获取锁");
                }

            }
        }catch (Exception e){
            System.out.println("异常");
        }


    }

}
