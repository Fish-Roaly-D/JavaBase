package com.roily.stack;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Stack.java
 * @author: RoilyFish
 * @date: 2022/5/21 16:09
 */
public interface Stack<T> {

    /**
     * 栈判空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param t
     */
    void push(T t);

    /**
     * 获取栈顶元素,未出栈
     *
     * @return t
     */
    T peek();

    /**
     * 出栈
     *
     * @return t
     */
    T pop();

    /**
     * 返回栈元素个数
     *
     * @return int
     */
    int size();

    /**
     * 清除栈
     */
    void clear();
}
