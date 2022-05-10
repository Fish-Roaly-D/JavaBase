package com.roily.queue.queue01;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0.0
 * @Description 自定义栈、队
 * @ClassName QueueAndStack.java
 * @author: RoilyFish
 * @date: 2022/5/1 18:15
 */

public class QueueAndStack {

    @Test
    public void Queue() {

        ArrayDequeQueue arrayDequeQueue = new ArrayDequeQueue();
        arrayDequeQueue.add("1");
        arrayDequeQueue.add(2);
        arrayDequeQueue.add("3");
        Object o = null;

        while ((o = arrayDequeQueue.get()) != null)
            System.out.println(o);

    }

    @Test
    public void Stack() {

        ArrayDequeStack arrayDequeStack = new ArrayDequeStack();
        arrayDequeStack.add("1");
        arrayDequeStack.add(2);
        arrayDequeStack.add("3");
        Object o = null;

        while ((o = arrayDequeStack.get()) != null)
            System.out.println(o);

    }


}

//队就是一个先进先出数据结构
class ArrayDequeQueue {

    //构造器初始化
    Deque<Object> myQueue;

    public ArrayDequeQueue() {
        this.myQueue = new ArrayDeque<>();
    }

    public void add(Object obj) {
        myQueue.addFirst(obj);
    }

    public Object get() {
        return myQueue.pollLast();
    }
}

//栈就是一个先进后出、后进先出数据结构
class ArrayDequeStack {

    //构造器初始化
    Deque<Object> myQueue;

    public ArrayDequeStack() {
        this.myQueue = new ArrayDeque<>();
    }

    public void add(Object obj) {
        myQueue.addLast(obj);
    }

    public Object get() {
        return myQueue.pollLast();
    }
}
