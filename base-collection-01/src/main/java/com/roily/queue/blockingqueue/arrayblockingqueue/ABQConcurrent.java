package com.roily.queue.blockingqueue.arrayblockingqueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version 1.0.0
 * @Description ABQ 同步理解 与Linklist做对比
 * @ClassName ABQConcurrent.java
 * @author: RoilyFish
 * @date: 2022/5/13 0:41
 */
public class ABQConcurrent {


    /**
     * ①同步、阻塞、有界、单向队列
     * ②读写使用同一把锁 ReentrantLock，可自定义是否公平
     * ③通多两个等待队列notFull和notEmpty来管理入队出队等待线程
     */

    //测试linkedList非同步
    @Test
    public void testLinkedList() {

        LinkedList<Integer> list = new LinkedList<>();
        //添加10000个元素
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        //创建10个线程去取
        //会报NoSuchElementException异常，也就是first节点为空，在当前线程获取时，已经有节点修改了first节点为空
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (list.size() > 0)
                    list.pop();
            }).start();
        }

    }


    //测试ABQ同步
    @Test
    public void testABQ() {

        ArrayBlockingQueue<Integer> list = new ArrayBlockingQueue<>(10000);
        //添加10000个元素
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        //创建10个线程去取
        //是没有问题的
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (list.size() > 0)
                    list.poll();
            }).start();
        }

    }


    /**
     * 测试ABQ在达到容量后，再次执行添加元素操作会阻塞
     */
}
