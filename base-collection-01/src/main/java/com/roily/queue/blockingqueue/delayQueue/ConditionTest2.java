package com.roily.queue.blockingqueue.delayQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @Description awaitNanos等待时长会不会叠加
 * @ClassName ConditionTest2.java
 * @author: RoilyFish
 * @date: 2022/5/6 12:31
 */
public class ConditionTest2 {

    //会叠加等待但没有意义
    public static void testConditionAdd() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {

            lock.lock();
            try {
                long start = System.currentTimeMillis();
                condition.awaitNanos(TimeUnit.MILLISECONDS.toNanos(3000));
                condition.awaitNanos(TimeUnit.MILLISECONDS.toNanos(2000));
                System.out.println("花费时长:=>" + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                System.out.println("中断异常");
            } finally {
                lock.unlock();
            }

        }).start();

        Thread.sleep(1000);
    }


    public static void main(String[] args) throws InterruptedException {

        testConditionAdd();

    }

}
