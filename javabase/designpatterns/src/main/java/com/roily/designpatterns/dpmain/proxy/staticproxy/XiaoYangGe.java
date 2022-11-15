package com.roily.designpatterns.dpmain.proxy.staticproxy;

import lombok.Data;
import org.junit.Test;

/**
 * @Date: 2022/08/29/13:55
 * @Description:
 */
@Data
public class XiaoYangGe implements SellGoods {
    //小杨哥代理的品牌方
    private SellGoods sellGoods;

    @Override
    public void doSell() {
        prev();
        sellGoods.doSell();
        last();
    }

    private void prev(){
        System.out.println("测评、口碑、流量");
    }

    private void last(){
        System.out.println("质保");
    }

    @Test
    public void test(){
        //代理对象
        final XiaoYangGe xiaoYangGe = new XiaoYangGe();
        //代理对象组合真实对象
        xiaoYangGe.setSellGoods(new GoodsOwner());
        //代理对象对真实对象做增强
        xiaoYangGe.doSell();
    }
}
