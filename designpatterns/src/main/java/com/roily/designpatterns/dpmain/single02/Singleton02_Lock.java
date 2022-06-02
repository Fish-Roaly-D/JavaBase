package com.roily.designpatterns.dpmain.single02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description 懒汉式、线程安全（ReentrantLock）
 * @ClassName Singleton02_Syn.java
 * @author: RoilyFish
 * @date: 2022/6/2 11:28
 */
public class Singleton02_Lock {

    private static Singleton02_Lock instance;
    static ReentrantLock lock = new ReentrantLock();

    private Singleton02_Lock() {
        System.out.println("创建" + this.getClass().getName());
    }

    public static Singleton02_Lock getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Singleton02_Lock();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return instance;
    }

}

