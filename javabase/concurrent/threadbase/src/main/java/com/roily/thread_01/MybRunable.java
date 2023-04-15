package com.roily.thread_01;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/13
 */
public class MybRunable implements Runnable {
    @Override
    public void run() {
        //业务
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"=>"+i);
        }
    }

}
