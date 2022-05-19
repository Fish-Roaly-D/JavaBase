package com.roily.DelayQueueTest;

import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description
 * @ClassName DelayedTest.java
 * @author: RoilyFish
 * @date: 2022/5/5 19:22
 */
class DelayQueueTest {

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


class MyDelayed implements Delayed {

    long time = System.currentTimeMillis();

    TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    public MyDelayed(long time) {
        this.time += time;
    }

    public MyDelayed() {
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(timeUnit) < o.getDelay(timeUnit))
            return -1;
        else if (this.getDelay(timeUnit) > o.getDelay(timeUnit))
            return 1;
        else
            return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - System.currentTimeMillis(), timeUnit);
    }

    public long getDelay() {
        return this.getDelay(timeUnit);
    }

}
