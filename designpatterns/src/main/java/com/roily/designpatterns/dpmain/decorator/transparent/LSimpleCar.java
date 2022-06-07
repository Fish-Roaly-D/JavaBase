package com.roily.designpatterns.dpmain.decorator.transparent;

/**
 * @version 1.0.0
 * @Description
 * @ClassName LSimpleCar.java
 * @author: RoilyFish
 * @date: 2022/6/7 14:18
 */
public class LSimpleCar extends SimpleCar {

    public LSimpleCar(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("支持自动驾驶");
    }
}
