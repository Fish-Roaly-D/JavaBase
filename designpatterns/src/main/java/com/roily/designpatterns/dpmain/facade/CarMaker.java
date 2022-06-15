package com.roily.designpatterns.dpmain.facade;

/**
 * @version 1.0.0
 * @Description
 * @ClassName CarMaker.java
 * @author: RoilyFish
 * @date: 2022/6/7 16:51
 */
public class CarMaker {
    /**
     * 如果不是静态方法可以将需要的类组合进来
     */

    public static void makeCar() {
        DesignCar.design();
        Produce.produce();
        Assemble.assemble();
    }

}
