package com.roily.designpatterns.dpmain.proxy.notstaticproxy;

/**
 * @version 1.0.0
 * @Description 代理人，帮挂牌销售
 * @ClassName HouseProxy.java
 * @author: RoilyFish
 * @date: 2022/6/8 22:57
 */
public class HouseProxy implements SellHouse, IHouseProxy {

    /**
     * 被代理对象,只代理一个
     */
    private HouseOwner houseOwner = new HouseOwner();


    /**
     * 销售也卖房子,但是包括前置服务和后续维护服务
     */
    @Override
    public void sellHouse() {
        prevWork();
        houseOwner.sellHouse();
        nextWork();
    }


    @Override
    public void prevWork() {
        System.out.println("挂牌");
        System.out.println("联系客户");
        System.out.println("签合同");
    }

    @Override
    public void nextWork() {
        System.out.println("维护");
    }

}
