package com.roily.base.collectionframework.base.queue.concurrentlinkedqueue;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @version 1.0.0
 * @Description
 * @ClassName CLQTakeANDPoll.java
 * @author: RoilyFish
 * @date: 2022/5/16 18:32
 */
public class CLQTakeANDPoll {


    /**
     * 我们知道，Queue定义的peek()方法，只做获取元素操作，不会对队列做修改
     *
     * CLQ初始化时head和tail指向Node(Null,Null),在插入元素后后继节点next会改变，而item永远都是null。
     *
     * peek获取元素的条件为 item不为空或队列为空
     *
     * peek方法会在首次获取值时，将head移动到首个item不为空的节点处。
     */
    @Test
    public void testPeek(){

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }

    /**
     * 当队列为空时，返回null。
     */
    @Test
    public void testPeek02(){

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        System.out.println(queue.peek());
        System.out.println(queue.peek());

    }











}
