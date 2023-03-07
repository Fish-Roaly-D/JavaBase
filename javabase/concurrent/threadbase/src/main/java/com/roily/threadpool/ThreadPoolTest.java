package com.roily.threadpool;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2023/03/07/17:49
 * @Description: 创建线程池
 */
public class ThreadPoolTest {


    @Test
    public void test1(){

        // 创建固定大小的线程池，不够则等待
        final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // 池中没有线程则创建并放入线程池
        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    }
    @Test
    public void test2() throws InterruptedException {

        // corePoolSize -线程池中保留的线程数，即使它们是空闲的，除非allowCoreThreadTimeOut设置了maximumPoolSize
        // maximumPoolSize-线程池中允许的最大线程数
        // keepAliveTime当线程数大于核心时，这是多余的空闲线程在终止前等待新任务的最大时间。
        // unit——keepAliveTime参数的时间单位。
        // workQueue——在任务执行之前用于保存任务的队列。这个队列将只保存execute方法提交的可运行任务。
        // threadFactory——当执行程序创建一个新的线程处理程序时使用的工厂
        // handler——当执行因为线程边界和队列容量达到而阻塞时使用的处理程序

        final CountDownLatch latch = new CountDownLatch(10);

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,10, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(),
                Thread::new,(e1, e2)->{
            System.out.println("线程池满了");
            System.out.println(e2.hashCode());
        });

        System.out.println(threadPoolExecutor.hashCode());

        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        latch.await();

    }

}
