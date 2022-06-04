package com.roily.designpatterns.dpmain.builder.usebuilder;

import lombok.ToString;

/**
 * @version 1.0.0
 * @Description 新能源汽车
 * @ClassName GreenCar.java
 * @author: RoilyFish
 * @date: 2022/6/4 13:46
 */
@ToString
public class GreenCar {
    //电机
    private String motor;
    //电池
    private String battery;
    //电控
    private String electronicControl;
    //品牌
    private String brand;

    /**
     * 上面必须、下面选配
     */

    //是否自持自动驾驶
    private Boolean autopilot;

    public GreenCar(String brand) {

        this.brand = brand;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setElectronicControl(String electronicControl) {
        this.electronicControl = electronicControl;
    }
    public void setAutopilot(Boolean autopilot) {
        this.autopilot = autopilot;
    }
}
