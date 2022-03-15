package com.roily;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/15
 */
public class SynchronizedDeom01 {
    //共享数据
    private static Integer a = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    a++;
                }
            }).start();
        }

        //保证非main线程先执行
        Thread.sleep(1000);
        System.out.println(a);
    }
}
