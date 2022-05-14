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

    //resize方法测试
    @Test
    public void testResize(){

        ArrayQueue<Object> queue = new ArrayQueue<>(10);

        queue.resize(9);



    }


}
