package com.roily.designpatterns.dpmain.proxy.jdkproxy;

import com.roily.designpatterns.dpmain.proxy.common.CommonInvocationHandler;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Clinet.java
 * @author: RoilyFish
 * @date: 2022/6/8 23:46
 */
public class Clinet {


    @Test
    public void test(){
        SellHouseHandler sellHouseHandler = new SellHouseHandler();
        sellHouseHandler.setSellHouse(new HouseOwner());
        SellHouse proxy = (SellHouse)sellHouseHandler.getProxy();
        proxy.sell();
    }

    /**
     * 测试通用写法
     */
    @Test
    public void test2(){
        CommonInvocationHandler commonInvocationHandler = new CommonInvocationHandler();
        commonInvocationHandler.setObject(new HouseOwner());
        SellHouse proxy = (SellHouse)commonInvocationHandler.getProxy();
        proxy.sell();
    }

}
