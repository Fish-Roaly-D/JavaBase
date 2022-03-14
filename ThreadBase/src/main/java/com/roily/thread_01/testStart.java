package com.roily.thread_01;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/13
 */
public class testStart {


    @Test
    public void testThread() {

        MyThread myThread = new MyThread();

        myThread.start();

    }

    @Test
    public void testRunable() {

        Thread thread = new Thread(new MybRunable());
        thread.start();

    }

    @Test
    public void testCallable() throws ExecutionException, InterruptedException {

        MyCallable myCallable = new MyCallable();

        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<String> submit = service.submit(myCallable);

        System.out.println(submit.get());

    }

    @Test
    public void testRunableNoName() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现runable接口");
            }
        }).start();

    }

    @Test
    public void testRunableLambda() {

        new Thread(() -> {
            System.out.println("lambda表达式实现runable接口");
        }).start();
    }

    @Test
    public void testFutureTask() throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = null;
        new Thread(futureTask = new FutureTask<String>(new Runnable() {
            public void run() {
                System.out.println(1);
            }
        }, "result")).start();

        Object o = futureTask.get();

        System.out.println(o);
    }

    @Test
    public void testFutureTask_() throws ExecutionException, InterruptedException {

        FutureTask futureTask = null;
        futureTask = new FutureTask<String>(new Runnable() {
            public void run() {
                System.out.println(1);
            }
        }, "xxx");
        ExecutorService service = Executors.newCachedThreadPool();
        Future<?> submit = service.submit(futureTask);
        System.out.println(submit);
    }

    @Test
    public void testFutureTask2() throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = null;
        new Thread(futureTask = new FutureTask<String>(new Callable<String>() {
            public String call() throws Exception {
                return "xxxx";
            }
        })).start();

        Object o = futureTask.get();

        System.out.println(o);
    }

    @Test
    public void testRunToCall() throws ExecutionException, InterruptedException {

        Runnable runnable = () -> System.out.println("lambda");

        Callable<String> callable = Executors.callable(runnable, "result");

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> submit = service.submit(callable);

        System.out.println(submit.get());

    }

    @Test
    public void testRunToPoll() throws ExecutionException, InterruptedException {

        Runnable runnable = () -> System.out.println("lambda");

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> submit = service.submit(runnable, "result");

        System.out.println(submit.get());

    }

}
