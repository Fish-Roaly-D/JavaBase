package com.roily.base.collectionframework.base.queue.blockingqueue.linkedblockingqueue;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Description
 * @ClassName LBQAtomicInteger.java
 * @author: RoilyFish
 * @date: 2022/5/13 1:04
 */
public class LBQAtomicInteger {

    /**
     * ①LBQ是一个同步、阻塞、无界(最大intmax)、使用单向链表实现的单向队列
     * ②读写分离，使用两个锁putLock、takeLock分别管理入队、出队操作
     * ③使用两个等待队列，notFull、notEmpty分别管理入队、出队等待操作
     * ④内部通过count来判断是否需要等待、一般来说入队操作不会等待，出队操作当count==0时，进入notEmpty等待队列
     *  由于使用读写分离，所以对count这恶鬼类似状态变量需要使用原子的 也就是AtomicInteger
     */

    /**
     * AtomicInteger线程安全理解
     *
     * ①Unsafe包下的cas操作
     * ②valueOffset偏移量，用于快速检索内存中的对象，cas失败及更新
     * ③volatile修饰的int，保证内存可见、有序性
     *
     * cas+volatile+valueOffset即可实现线程安全。
     *
     * 修改值时：
     * 首先尝试cas修改，如若修改失败，立刻获取内存中的最新值，更新当前变量，再次尝试直至cas成功。
     *
     */
    //测试AtomicInteger线程安全
    @Test
    public void testAtomicInteger() throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(atomicInteger.get());
    }

}
