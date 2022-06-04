package com.roily.designpatterns.dpmain.builder.usebuilder;

/**
 * @version 1.0.0
 * @Description 抽象建造者
 * @ClassName IBuilder.java
 * @author: RoilyFish
 * @date: 2022/6/4 14:13
 */
public interface IBuilder {

    void setMotor();

    void setBattery();

    void setElectronicControl();

    void setAutopilot();

    GreenCar build();
}
