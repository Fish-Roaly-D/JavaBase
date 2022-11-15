package com.roily.synchronizedDemo;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName SynchronizedBlockClass.java
 * @author: RoilyFish
 * @date: 2022/3/17 21:19
 */
public class SynchronizedBlockClass {
    //共享数据
    private static Integer a = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
                synchronized (SynchronizedBlockClass.class) {
                    for (int j = 0; j < 100; j++) {
                        a++;
                    }
                }
            }).start();
            //保证前一个线程start
            //Thread.sleep(500);

        }
        //保证非main线程执行结束
        Thread.sleep(5000);
        System.out.println(a);
    }
}

class SynchronizedBlockClass2 {


    private static Integer a = 0;

    public static synchronized void add() {
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
            }).start();
        }
        //保证非main线程执行结束
        Thread.sleep(2000);
        System.out.println(a);

    }

}