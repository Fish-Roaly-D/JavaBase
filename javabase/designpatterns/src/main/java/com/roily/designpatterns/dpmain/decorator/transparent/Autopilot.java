package com.roily.designpatterns.dpmain.decorator.transparent;


/**
 * @version 1.0.0
 * @Description
 * @ClassName Autopilot.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:18
 */
public class Autopilot extends AbstractDecorator{

    public Autopilot(BaseCar baseCar) {
        super.setBaseCar(baseCar);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("支持自动驾驶");
    }
}
