package com.roily.designpatterns.dpmain.bridge;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName Apple.java
 * @author: RoilyFish
 * @date: 2022/6/6 19:48
 */
public class Apple extends Brand {

    public Apple(ElectronicProduct electronicProduct) {
        super(electronicProduct);
    }

    @Override
    void name() {
        System.out.println("Apple品牌");
        electronicProduct.name();
    }
}
