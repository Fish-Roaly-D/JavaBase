package com.roily.booknode.javatogod._13jvm.reorder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2023/02/28/14:22
 * @Description:
 */
public class ReorderExample {

    int a = 0;
    boolean flag = false;

    public synchronized void writer() {
        a = 1;
        flag = true;
    }

    synchronized void reader() {
        if (flag) {
            int i = a * a;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final ReorderExample reorderExample = new ReorderExample();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), (r) -> {
            return new Thread(r);
        });
        int i = 2;
        threadPoolExecutor.execute(()->{
            reorderExample.writer();
        });
        countDownLatch.countDown();
        threadPoolExecutor.execute(()->{
            reorderExample.reader();
            System.out.println(1);
        });
        countDownLatch.countDown();
        countDownLatch.await();
        threadPoolExecutor.shutdown();
    }

}
