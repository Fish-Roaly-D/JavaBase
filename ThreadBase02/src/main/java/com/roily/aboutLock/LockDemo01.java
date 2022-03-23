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
