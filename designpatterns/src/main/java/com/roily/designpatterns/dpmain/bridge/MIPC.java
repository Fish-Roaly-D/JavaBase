package com.roily.designpatterns.dpmain.bridge;

/**
 * @version 1.0.0
 * @Description
 * @ClassName MIPC.java
 * @author: RoilyFish
 * @date: 2022/6/6 19:39
 */
public class MIPC implements ElectronicProduct {
    @Override
    public void name() {
        System.out.println("小米电脑");
    }
}
