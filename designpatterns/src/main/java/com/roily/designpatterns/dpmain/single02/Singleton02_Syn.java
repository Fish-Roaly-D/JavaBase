package com.roily.designpatterns.dpmain.single02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description 懒汉式、线程安全（Synchronized）
 * @ClassName Singleton02_Syn.java
 * @author: RoilyFish
 * @date: 2022/6/2 11:28
 */
public class Singleton02_Syn {

    private static Singleton02_Syn instance;


    private Singleton02_Syn() {
        System.out.println("创建" + this.getClass().getName());
    }

    public static synchronized Singleton02_Syn getInstance() {
        if (instance == null) {
            instance = new Singleton02_Syn();
        }
        return instance;
    }

    static ReentrantLock lock = new ReentrantLock();

    public static Singleton02_Syn getInstance2() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Singleton02_Syn();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

        return instance;
    }
}

