package com.roily.stack.arraystack;

import com.roily.stack.Stack;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @Description 借助ArrayList实现栈
 * @ClassName ArrayStackByArrayList.java
 * @author: RoilyFish
 * @date: 2022/5/23 1:58
 */
public class ArrayStackByArrayList<T> extends ArrayList<T> implements Stack<T> {

    private static final long serialVersionUID = 893214352865117027L;

    @Override
    public void push(T t) {
        super.add(t);
    }

    @Override
    public T peek() {
        return get(size()-1);
    }

    @Override
    public T pop() {
        return remove(size()-1);
    }
}
