package com.roily.designpatterns.dpmain.builder.usebuilder;

/**
 * @version 1.0.0
 * @Description 创建对象算法
 * @ClassName GreenCarDirector.java
 * @author: RoilyFish
 * @date: 2022/6/4 14:19
 */
public class GreenCarDirector {

    //指导产品创建算法
    public void makeGreenCar(IBuilder builder){
        builder.setAutopilot();
        builder.setBattery();
        builder.setElectronicControl();
        builder.setMotor();
    }

}
