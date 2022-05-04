package com.roily.ArrayBlock;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version 1.0.0
 * @Description ABQ获取元素
 * @ClassName ArrayBlockGet.java
 * @author: RoilyFish
 * @date: 2022/5/4 0:05
 */
public class ArrayBlockGet {

    @Test
    public void testPoll() throws InterruptedException {

        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(15);


        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        //peek方法是真正意义上的获取元素
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());

        //poll  和  take 是出队操作  会修改 入队出队指针
        //poll获取失败 返回null(也就是队列为空)
        //take会响应中断异常
        System.out.println(queue.poll());
        System.out.println(queue.take());
        System.out.println(queue.take());

    }


}
