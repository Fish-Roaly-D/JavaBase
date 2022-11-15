package com.roily.thread_03;

public class Daemon {
    public static void main(String[] args) {
        Thread gad = new Thread(new gad(), "守护线程");
        //设置为守护线程
        gad.setDaemon(true);
        Thread you = new Thread(new you(), "用户线程");

        gad.start();
        you.start();
    }
}

class you implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("用户线程执行业务");
        }
        System.out.println("用户线程执行结束");
    }
}

class gad implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("守护线程执行任务【监控、日志、gc。。】");
        }
    }
}