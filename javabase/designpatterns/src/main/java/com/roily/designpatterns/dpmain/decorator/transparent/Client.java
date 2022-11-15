package com.roily.designpatterns.dpmain.decorator.transparent;


import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/7 14:05
 */
public class Client {

    @Test
    public void test01(){
        BaseCar byd = new SimpleCar("比亚迪");
        //使用装饰器包装
        BaseCar autopilot = new Autopilot(byd);
        autopilot.run();
        BaseCar green = new Green(autopilot);
        green.run();
    }

    /**
     * 继承实现拓展
     */
    @Test
    public void test02(){

        BaseCar byd = new LSimpleCar("比亚迪");

        byd.run();
    }

}
