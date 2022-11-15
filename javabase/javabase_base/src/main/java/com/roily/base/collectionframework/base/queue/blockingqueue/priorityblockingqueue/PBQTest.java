package com.roily.base.collectionframework.base.queue.blockingqueue.priorityblockingqueue;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description
 * @ClassName PBQTest.java
 * @author: RoilyFish
 * @date: 2022/5/13 23:31
 */
public class PBQTest {

    //priorityBlockingQueue 会将无序队列，构建为有序二叉树
    @Test
    public void testConstructor(){
        ArrayQueue<Integer> aQueue = new ArrayQueue<>(10);
        for (int i = 10; i > 0; i--) {
            aQueue.add(i);
        }
        System.out.println("原数组：");
        aQueue.forEach((element)->{
            System.out.printf(element+",");
        });

        System.out.println("\n"+"使用PQ转化");
        PriorityQueue<Integer> queue = new PriorityQueue<>(aQueue);

        queue.forEach((element)->{
            System.out.printf(element+",");
        });

    }


    /**
     * PBQ出队操作：take() 和poll(time,timeUnit)会等待。
     *
     * 测试poll(time,timeUnit)达到超市时间会不会返回nul。
     *
     * 结果：poll(time,timeUnit)在达到超时时间后，获取得到锁资源，若此刻队列还是为空则返回null
     */
    @Test
    public void testPBQPOLL() throws InterruptedException {

        PriorityBlockingQueue<Object> pbq = new PriorityBlockingQueue<>();
        //等三秒
        System.out.println(pbq.poll(3000, TimeUnit.MILLISECONDS));

    }



}
