package com.roily.designpatterns.dpmain.builder.usebuilder;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName test.java
 * @author: RoilyFish
 * @date: 2022/6/4 14:27
 */
public class test {


    @Test
    public void test(){

        //创建一个指导，生产类
        GreenCarDirector greenCarDirector = new GreenCarDirector();

        //创建比亚迪构建者
        IBuilder bydBuilder = new BYDBuilder();

        //创建比亚迪构建者
        IBuilder tslBuilder = new TSLBuilder();


        //生产比亚迪
        greenCarDirector.makeGreenCar(bydBuilder);
        GreenCar greenCar1 = bydBuilder.build();
        System.out.println(greenCar1.toString());

        //生产特斯拉
        greenCarDirector.makeGreenCar(tslBuilder);
        GreenCar greenCar2 = tslBuilder.build();
        System.out.println(greenCar2.toString());
    }

}
