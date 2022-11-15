package com.roily.designpatterns.dpmain.proxy.notstaticproxy;

/**
 * @version 1.0.0
 * @Description 房东
 * @ClassName HouseOwner.java
 * @author: RoilyFish
 * @date: 2022/6/8 22:56
 */
public class HouseOwner implements SellHouse {

    @Override
    public void sellHouse() {
        System.out.println("房东卖房子");
    }
}
