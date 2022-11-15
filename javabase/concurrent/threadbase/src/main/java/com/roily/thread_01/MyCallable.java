package com.roily.thread_01;

import java.util.concurrent.Callable;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/13
 */
public class MyCallable implements Callable<String> {

    public String call() throws Exception {
        //业务
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"=>"+i);
        }
        return "执行完毕";

    }

}
