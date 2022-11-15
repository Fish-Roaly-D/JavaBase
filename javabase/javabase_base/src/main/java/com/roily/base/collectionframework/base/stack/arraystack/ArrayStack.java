package com.roily.base.collectionframework.base.stack.arraystack;

import com.roily.base.collectionframework.base.stack.Stack;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.function.Consumer;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ArrayStack.java
 * @author: RoilyFish
 * @date: 2022/5/21 16:14
 */
public class ArrayStack<T> implements Stack<T>, Serializable {

    //序列号
    private static final long serialVersionUID = 6348894725654782270L;

    //栈元素个数
    private int size;

    // 容量大小默认为10
    private int capacity = 10;

    //栈顶指针,-1代表空栈
    private int top = -1;

    //存放元素的数组
    private T[] element;

    public ArrayStack() {
        element = (T[]) new Object[capacity];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        element = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public void push(T t) {
        //确保容量够
        ensureCapacity();
        element[++top] = t;
        size++;
    }

    @Override
    public T peek() {
        //栈判空
        if (isEmpty())
            throw new EmptyStackException();
        return element[top];
    }

    @Override
    public T pop() {
        //栈判空
        if (isEmpty())
            throw new EmptyStackException();
        size--;
        return element[top--];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(element, null);
        size = 0;
        top = -1;
    }

    //确保容量足够
    public void ensureCapacity() {
        final int oldCapacity = capacity;
        int newCapacity;
        if (oldCapacity > size())
            return;
        //扩容
        newCapacity = oldCapacity * 2 + 1;
        element = Arrays.copyOf(element, newCapacity);
    }

    public void foreach(Consumer<T> action) {
        for (int i = 0; i < size; i++) {
            action.accept(element[i]);
        }
    }
}
