package com.roily.booknode.javatogod._11thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreads {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AtomicInteger no = new AtomicInteger();
        System.out.println(Thread.currentThread().getName());
        System.out.println("通过线程池创建线程");
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), (r) -> {
            //线程名前缀
            String namePrefix = "线程：";
            Thread t = new Thread(null, r, namePrefix + no.getAndIncrement(), 0);
            //设置为费守护线程
            t.setDaemon(false);
            //设置线程优先级为5
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        });
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));

        executorService.shutdown();
    }
}
