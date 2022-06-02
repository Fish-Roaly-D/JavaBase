package com.roily.designpatterns.dpmain.single;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Test05.java
 * @author: RoilyFish
 * @date: 2022/6/2 12:40
 */
public class Test05 {

    /**
     * 直接引用也不会触发静态内部类的初始化
     */
    @Test
    public void testx() {
        System.out.println(Singleton05.i);
    }

    /**
     * 双重校验锁，并发环境下线程安全问题
     */
    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
        while (true) ;
    }
}
