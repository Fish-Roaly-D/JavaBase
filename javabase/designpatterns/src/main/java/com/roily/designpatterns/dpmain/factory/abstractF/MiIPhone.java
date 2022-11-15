package com.roily.designpatterns.dpmain.factory.abstractF;

/**
 * @version 1.0.0
 * @Description
 * @ClassName MiIPhone.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:39
 */
public class MiIPhone implements IPhone {

    @Override
    public void ProductionPhone() {
        System.out.println("生产小米手机");
    }
}
