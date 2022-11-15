package com.roily.designpatterns.dpmain.single.single03;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Test03.java
 * @author: RoilyFish
 * @date: 2022/6/2 11:56
 */
public class Test03 {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
        while (true) ;
    }

    //测试我只想用一下int，但是却给我实例化了实例
    @Test
    public void test2() {

        System.out.println(Singleton03.i);
    }

}
