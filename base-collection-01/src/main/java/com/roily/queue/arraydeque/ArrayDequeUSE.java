package com.roily.queue.arraydeque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @version 1.0.0
 * @Description 使用ArrayDeque实现队列和栈
 * @ClassName ArrayDequeUSE.java
 * @author: RoilyFish
 * @date: 2022/5/11 22:55
 */
public class ArrayDequeUSE {

    @Test
    public void testMyQueue() {
        MyQueue<String> myQueue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            myQueue.add("" + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(myQueue.pop());
        }
    }

    @Test
    public void testMyStack() {
        MyStack<String> myStack = new MyStack<String>();
        for (int i = 0; i < 10; i++) {
            myStack.add("" + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack.pop());
        }
    }

}

/**
 * 使用ArrayDeque实现队列
 * addLast 配合 removeFirst
 * addFirst 配合 removeLast
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
class MyQueue<T> {

    private ArrayDeque<T> deque = new ArrayDeque<>();

    void add(T t) {
        //默认addLast
        deque.add(t);
    }

    T pop() {
        //默认removeFirst
        return deque.pop();
    }

    void addFirst(T t) {
        deque.addFirst(t);
    }

    T popLast() {
        return deque.removeLast();
    }

}

/**
 * 使用ArrayDeque实现栈
 * addLast 配合 removeLast\pollLast
 * addFirst 配合 removeFirst、pollFirst
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
class MyStack<T> {

    private ArrayDeque<T> deque = new ArrayDeque<>();

    void add(T t) {
        //默认addLast
        deque.add(t);
    }

    T pop() {
        return deque.pollLast();
    }

    void addFirst(T t) {
        deque.addFirst(t);
    }

    T popLast() {
        return deque.removeFirst();
    }

}