package com.roily.designpatterns.dpmain.single.single04;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 双重校验锁测试
 * @ClassName Test04.java
 * @author: RoilyFish
 * @date: 2022/6/2 12:13
 */
public class Test04 {

    /**
     * 双重校验锁，并发环境下线程安全问题
     */
    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton04.getSingleton().hashCode());
            }).start();
        }
        while (true) ;
    }

}
