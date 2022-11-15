package com.roily.thread_03;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
public class SleepAndWait {

    private static final String str1 = "a";
    private static final String str2 = "b";


    public static void main(String[] args) {
        SleepAndWait sleepAndWait = new SleepAndWait();
        //sleepAndWait.test();
        sleepAndWait.test2();
    }


    public void test(){
        new Thread(()->{
            synchronized (str1){
                System.out.println("拿到str1=>"+str1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (str2){
                    System.out.println("锁住str2=>"+str2);
                }
            }
        }).start();

        new Thread(()->{
            synchronized (str2){
                System.out.println("拿到str2=>"+str2);
                synchronized (str1){
                    System.out.println("锁住str1=>"+str1);
                }
            }
        }).start();
    }

    public synchronized void test2()   {
        Thread thread1 = new Thread(() -> {

        });

        Thread thread2 = new Thread(() -> {

        });

        thread1.start();

        thread2.start();


        try {
            thread1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }




}
