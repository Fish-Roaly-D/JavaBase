package com.roily.designpatterns.dpmain.builder.usebuilder;

import lombok.ToString;

/**
 * @version 1.0.0
 * @Description 比亚迪建造者
 * @ClassName BYDBuilder.java
 * @author: RoilyFish
 * @date: 2022/6/4 14:15
 */

public class BYDBuilder implements IBuilder{

    private GreenCar greenCar;

    public BYDBuilder() {
        this.greenCar = new GreenCar("比亚迪，海豹");
    }

    @Override
    public void setMotor() {
        greenCar.setMotor("比亚迪电机");
    }

    @Override
    public void setBattery() {
        greenCar.setBattery("刀片电池");
    }

    @Override
    public void setElectronicControl() {
        greenCar.setElectronicControl("比亚迪电控");
    }

    @Override
    public void setAutopilot() {
        greenCar.setAutopilot(true);
    }

    @Override
    public GreenCar build() {
        return greenCar;
    }

}
