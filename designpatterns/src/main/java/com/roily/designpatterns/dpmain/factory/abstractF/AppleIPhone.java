package com.roily.designpatterns.dpmain.factory.abstractF;

/**
 * @version 1.0.0
 * @Description 苹果手机
 * @ClassName AppleIPhone.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:43
 */
public class AppleIPhone implements IPhone {

    @Override
    public void ProductionPhone() {

        System.out.println("生产苹果手机");

    }
}