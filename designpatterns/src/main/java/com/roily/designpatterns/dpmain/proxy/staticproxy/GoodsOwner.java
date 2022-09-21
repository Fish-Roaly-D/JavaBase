package com.roily.designpatterns.dpmain.proxy.staticproxy;

/**
 * @Date: 2022/08/29/13:54
 * @Description: 品牌方
 */
public class GoodsOwner implements SellGoods {

    @Override
    public void doSell() {
        System.out.println("小杨哥的品牌方");
    }

}
