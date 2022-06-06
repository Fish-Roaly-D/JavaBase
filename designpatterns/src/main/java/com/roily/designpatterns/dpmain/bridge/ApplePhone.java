package com.roily.designpatterns.dpmain.bridge;

/**
 * @version 1.0.0
 * @Description
 * @ClassName MIPhone.java
 * @author: RoilyFish
 * @date: 2022/6/6 19:38
 */
public class ApplePhone implements ElectronicProduct {

    @Override
    public void name() {

        System.out.println("Iphone");
    }
}
