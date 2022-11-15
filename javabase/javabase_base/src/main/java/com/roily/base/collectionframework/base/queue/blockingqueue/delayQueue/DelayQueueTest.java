package com.roily.base.collectionframework.base.queue.blockingqueue.delayQueue;

import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description 延时队列测试
 * @ClassName DelayQueueTest.java
 * @author: RoilyFish
 * @date: 2022/5/14 22:15
 */
public class DelayQueueTest {


    /**
     * DelayQueue的offer方法
     * <h>
     * q.offer(e);
     * if (q.peek() == e) {
     * leader = null;
     * available.signal();
     * }
     * </h>
     * <p>
     * 理解
     * ①leader是什么        =》首个等待线程
     * ②leader有什么用处    =》减少不必要的等待
     */

    //测试，当添加的元素，会堆放再队首时，leader线程会被唤醒
    @Test
    public void testLeader() throws InterruptedException {

        DelayQueue<MyDelayed> elements = new DelayQueue<>();
        for (int i = 10; i > 0; i--) {
            //添加许多延时时间很长的元素
            elements.add(new MyDelayed(2000000000, TimeUnit.MILLISECONDS));
        }
        //搞个线程来取
        Thread takeT = new Thread(() -> {
            try {
                elements.take();

                System.out.println(Thread.currentThread().getName()+"线程被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //此线程会等待
        takeT.start();

        Thread.sleep(2000);

        //打印线程状态
        System.out.println(takeT.getName() + "处于=>" + takeT.getState() + "状态");

        //添加一个只需等待  100的。 此操作会唤醒takeT
        elements.add(new MyDelayed(1000, TimeUnit.MILLISECONDS));

        //保证主线程一直运行
        while (true);
    }


}
