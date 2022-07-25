package com.roily.queue.arrayqueue;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ArrayQueueTest.java
 * @author: RoilyFish
 * @date: 2022/5/14 0:02
 */
public class ArrayQueueTest {

    /**
     * resize方法测试
     *
     * 调整数组容量
     * - 如果新数组长度小于旧数组元素个数，抛出下标异常
     * - 如果新数组长度加一等于原数组长度，直接return不做其他操作
     * - 否则新建数组，将元素组数据复制过来，并替换原arrayQueue中的数组
     */
    @Test
    public void testResize(){

        ArrayQueue<Object> queue = new ArrayQueue<>(10);

        queue.resize(9);
    }


}
