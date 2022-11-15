package com.roily.designpatterns.dpmain.single.single07;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Dtest.java
 * @author: RoilyFish
 * @date: 2022/6/2 13:22
 */
public class Dtest {

    @Test
    public void test(){

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(DataSource.getInstance().hashCode());
            }).start();
        }
        while (true) ;

    }

}
