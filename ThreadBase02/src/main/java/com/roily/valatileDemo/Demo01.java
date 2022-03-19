package com.roily.valatileDemo;

import lombok.ToString;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName Demo01.java
 * @author: RoilyFish
 * @date: 2022/3/19 16:28
 */
public class Demo01 {

    //共享数据
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (flag) {
                System.out.println("死循环执行中。。。。。。。。");
            }
            System.out.println("死循环结束");
        });

        t1.start();
        //主线程睡一会保证其他线程在主线程执行结束前，开始执行
        Thread.sleep(2000);
        flag = false;
        System.out.println("修改flag");
    }


}


class EntityForDemo {

    //共享数据
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (flag) {
                System.out.println("死循环执行中。。。。。。。。");
            }
            System.out.println("死循环结束");
        });

        t1.start();
        //主线程睡一会保证其他线程在主线程执行结束前，开始执行
        Thread.sleep(2000);
        flag = true;
        System.out.println("修改flag");

    }


}

class Demo03 {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (flag) {
            }
            System.out.println(Thread.currentThread().getName() + "死循环结束");
        }).start();

        new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
                System.out.println(Thread.currentThread().getName() + "修改flag=>" + flag);
        }).start();

        //保证主线程一直运行，不会强制刷新缓存
        while (true) ;
        //Thread.sleep(Integer.MAX_VALUE);
    }
}
class Demo04 {
    public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (flag) {
            }
            System.out.println(Thread.currentThread().getName() + "死循环结束");
        }).start();

        new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
                System.out.println(Thread.currentThread().getName() + "修改flag=>" + flag);
        }).start();

        //保证主线程一直运行，不会强制刷新缓存
        while (true) ;
        //Thread.sleep(Integer.MAX_VALUE);
    }
}
