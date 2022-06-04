package com.roily.designpatterns.dpmain.builder.usebuilder;

import lombok.ToString;

/**
 * @version 1.0.0
 * @Description 比亚迪建造者
 * @ClassName BYDBuilder.java
 * @author: RoilyFish
 * @date: 2022/6/4 14:15
 */
public class TSLBuilder implements IBuilder{

    private GreenCar greenCar;

    public TSLBuilder() {
        this.greenCar = new GreenCar("特斯拉");
    }

    @Override
    public void setMotor() {
        greenCar.setMotor("特斯拉电机");
    }

    @Override
    public void setBattery() {
        greenCar.setBattery("大头电池");
    }

    @Override
    public void setElectronicControl() {
        greenCar.setElectronicControl("特斯拉电控");
    }

    @Override
    public void setAutopilot() {
        greenCar.setAutopilot(false);
    }

    @Override
    public GreenCar build() {
        return greenCar;
    }

}
