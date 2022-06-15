package com.roily.designpatterns.dpmain.facade;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/7 16:41
 */
public class Client {

    @Test
    public void makeCar(){
        DesignCar.design();
        Produce.produce();
        Assemble.assemble();
    }


    public static void main(String[] args) {
        CarMaker.makeCar();
    }
}
