package com.roily.designpatterns.dpmain.decorator.simple;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AutopilotCar.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:18
 */
public class AutopilotCar extends BaseCar{

    public AutopilotCar(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("支持自动驾驶！");
    }
}
