package com.roily.designpatterns.dpmain.proxy.jdkproxy.jdk01;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0.0
 * @Description 房东
 * @ClassName HouseOwner.java
 * @author: RoilyFish
 * @date: 2022/6/8 22:56
 */
public class HouseOwner implements SellHouse {

    @Override
    public void sell(){
        System.out.println("房东卖房子");
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HouseOwner houseOwner = new HouseOwner();
        Method sell = HouseOwner.class.getDeclaredMethod("sell");
        sell.invoke(houseOwner, (Object) null);
    }

}
