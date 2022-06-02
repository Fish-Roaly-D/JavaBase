package com.roily.designpatterns.dpmain.single.single06;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 测试枚举类单线程、多线程环境下的单例
 * @ClassName Test06.java
 * @author: RoilyFish
 * @date: 2022/6/2 12:50
 */
public class Test06 {

    //单线程环境下
    @Test
    public void test(){
        System.out.println(Singleton06.INSTANCE.hashCode());
        System.out.println(Singleton06.INSTANCE.hashCode());
        System.out.println(Singleton06.INSTANCE.hashCode());
        System.out.println(Singleton06.INSTANCE.hashCode());
    }

    //多线程环境下
    @Test
    public void test2(){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton06.INSTANCE.hashCode());
            }).start();
        }
        while (true) ;
    }

}
