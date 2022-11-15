package com.roily.base.collectionframework.base.queue.blockingqueue.delayQueue;

import org.junit.Test;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description Delayed接口测试，延时的意思
 * @ClassName DelayedTest.java
 * @author: RoilyFish
 * @date: 2022/5/5 19:22
 */
public class DelayedTest {

    @Test
    public void testDelayed() throws InterruptedException {

        MyDelayed myDelayedFirst = new MyDelayed(10000);
        Thread.sleep(3000);
        MyDelayed myDelayedEnd = new MyDelayed(10000);
        Thread.sleep(3000);
        System.out.println("myDelayedFirst=>" + myDelayedFirst.getDelay());
        System.out.println("myDelayedEnd=>" + myDelayedEnd.getDelay());

    }


}

/**
 * Delayed接口是Comparable的子接口，
 * 实现它必须重写自己的getDelay()抽象方法和compareTo()方法
 */
class MyDelayed implements Delayed {
    //延时时间
    long delayTime;
    //创建时间
    final long creatTime = System.currentTimeMillis();
    //时间单位, 默认Nanos
    TimeUnit timeUnit = TimeUnit.NANOSECONDS;

    public MyDelayed(long delayTime, TimeUnit timeUnit) {
        this.delayTime = delayTime;
        this.timeUnit = timeUnit;
    }

    public MyDelayed(long delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay() < o.getDelay(timeUnit))
            return -1;
        else if (this.getDelay() > o.getDelay(timeUnit))
            return 1;
        else
            return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(creatTime - System.currentTimeMillis() + delayTime, timeUnit);
    }

    public long getDelay() {
        return this.getDelay(timeUnit);
    }

}
