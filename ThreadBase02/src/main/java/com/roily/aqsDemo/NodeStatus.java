package com.roily.aqsDemo;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName NodeStatus.java
 * @author: RoilyFish
 * @date: 2022/3/26 10:35
 */
public class NodeStatus {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                lock.lock();
                lock.lock();
            }finally {

            }
        }).start();
    }

    @Test
    public void test(){

        if (true){
            System.out.println(1);
        }else if (true){
            System.out.println(2);
        }
        System.out.println(3);

    }
}

class SyncStatus {

    public static void main(String[] args) {


    }
}
