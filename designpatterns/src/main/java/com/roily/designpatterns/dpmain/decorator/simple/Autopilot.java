package com.roily.designpatterns.dpmain.decorator.simple;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Autopilot.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:18
 */
public class Autopilot extends AbstractDecorator{

    public Autopilot(BaseCar baseCar) {
        super(baseCar);
    }

    @Override
    void expand() {
        super.getBaseCar().run();
        //添加拓展逻辑
        System.out.println("支持自动驾驶！");
    }
}
