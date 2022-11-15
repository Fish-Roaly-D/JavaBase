package com.roily.base.collectionframework.base.stack.linkedstack;

import com.roily.base.collectionframework.base.stack.Stack;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.function.Consumer;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ArrayStack.java
 * @author: RoilyFish
 * @date: 2022/5/21 16:14
 */
public class LinkedStack<T> implements Stack<T>, Serializable {

    @Data
    @AllArgsConstructor
    class Node {
        T value;
        Node next;
    }

    //序列号
    private static final long serialVersionUID = 6348894725654782270L;

    //栈元素个数
    private int size;

    //栈顶引用 为空代表 空栈
    private Node top = null;


    public LinkedStack() {

    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public void push(T t) {

        top = new Node(t, top);

        size++;
    }

    @Override
    public T peek() {
        //栈判空
        if (isEmpty())
            throw new EmptyStackException();
        return top.getValue();
    }

    @Override
    public T pop() {
        //栈判空
        if (isEmpty())
            throw new EmptyStackException();
        T value = top.getValue();
        top = top.next;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        //栈判空
        if (isEmpty()) return;
        top = null;
        size = 0;
    }

    public void foreach(Consumer<T> action) {
        Node topT = top;
        //栈判空
        if (isEmpty()) return;
        do {
            action.accept(topT.value);
        } while ((topT = topT.next) != null);
    }
}
