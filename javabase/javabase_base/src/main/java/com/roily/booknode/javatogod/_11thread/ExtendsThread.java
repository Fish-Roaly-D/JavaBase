package com.roily.booknode.javatogod._11thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @classname：ExtendsThread
 * @author: rolyfish
 * @description: todo
 * @date: 2022/9/13 23:46
 */
public class ExtendsThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new Thread(new ImplementsRunnable()).start();

        final ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        final FutureTask<String> vFutureTask = new FutureTask<>(implementsRunnable,"");
        new Thread(vFutureTask).start();


        final FutureTask<String> futureTask = new FutureTask<>(new ImplementsCallable());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
}

class ImplementsRunnable implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        final FutureTask<String> vFutureTask = new FutureTask<>(implementsRunnable,"xxx");
        new Thread(vFutureTask).start();
        //vFutureTask.get()是一个阻塞任务，可放置于最后，当主线程执行完后再来监控此返回结果
        //System.out.println(vFutureTask.get());
        //System.out.println("主线程。。。。。");

        System.out.println("主线程。。。。。");
        while (!vFutureTask.isDone())
        System.out.println(vFutureTask.get());
    }

}

class ImplementsCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }

    /**
     * peek要消费才起作用
     * @param args
     */
    public static void main(String[] args) {

        final StringBuilder sb1 = new StringBuilder("");
        final StringBuilder sb2= new StringBuilder("");
        final StringBuilder sb3= new StringBuilder("");

        final List<StringBuilder> stringBuilders = Arrays.asList(sb1, sb3, sb2);

        stringBuilders.stream().peek(ele -> ele.append("a")).toArray();

        System.out.println(stringBuilders);

    }
}