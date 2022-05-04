package com.roily.ArrayBlock;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version 1.0.0
 * @Description 同步 阻塞 有界队列
 * @ClassName ArrayBlockTest.java
 * @author: RoilyFish
 * @date: 2022/5/3 21:58
 */
public class ArrayBlockTest {


    //测试LinkedList不支持同步
    @Test
    public void testLinkedList() throws InterruptedException {

        LinkedList<Object> list = new LinkedList<Object>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {

                    list.add("");
                }
            }).start();
        }
        Thread.sleep(3000);
        //结果小于1000
        System.out.println(list.size());

    }

    //测试ArrayDeque不支持同步
    @Test
    public void testArrayDeque() throws InterruptedException {

        ArrayDeque<Object> deque = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    deque.add("");
                }
            }).start();
        }
        Thread.sleep(5000);
        //结果小于10000
        System.out.println(deque.size());
    }

    //测试PriorityQueue不支持同步
    @Test
    public void testPriorityQueue() throws InterruptedException {

        PriorityQueue<Object> queue = new PriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (Integer i1 = 0; i1 < 100; i1++) {
                    queue.add("");
                }
            }).start();
        }
        Thread.sleep(5000);
        //结果小于10000
        System.out.println(queue.size());
    }


    @Test
    public void testABQMethod() throws InterruptedException {

        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(10000);

        //创建一百个线程修改，边修改，边获取看报不报错
        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    queue.add("");
                }
            }).start();
        }

        Thread.sleep(5000);

        System.out.println(queue.size());
    }

    /**
     * clear()方法，不会对takeIndex 和putIndex做改动
     *
     * toArray()方法会根据添加顺序转化数组
     */
    @Test
    public void testABQClear() {

        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(15);

        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        queue.forEach((obj) -> {
            System.out.printf(obj + ",");
        });
        System.out.println();

        queue.clear();


        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        System.out.println();

        Object[] objects2 = queue.toArray();

        for (Object obj : objects2) {
            System.out.printf(obj + ",");
        }

    }

    /**
     * add()方法会不会无限add()  add失败返回false
     */


}
