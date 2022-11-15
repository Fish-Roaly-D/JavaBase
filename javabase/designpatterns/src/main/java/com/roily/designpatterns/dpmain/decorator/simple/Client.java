package com.roily.designpatterns.dpmain.decorator.simple;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:20
 */
public class Client {

    /**
     * 简单装饰器模式测试
     */
    @Test
    public void test(){
        BaseCar byd = new BaseCar("比亚迪");
        //使用装饰器包装
        AbstractDecorator autopilot = new Autopilot(byd);
        autopilot.expand();
    }

    /**
     * 继承实现拓展
     */
    @Test
    public void test02(){

        BaseCar autopilotCar = new AutopilotCar("比亚迪");
        autopilotCar.run();
    }

}
