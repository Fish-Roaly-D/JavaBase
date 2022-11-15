package com.roily.designpatterns.dpmain.builder.unusebuilder;

/**
 * @version 1.0.0
 * @Description 新能源汽车
 * @ClassName GreenCar.java
 * @author: RoilyFish
 * @date: 2022/6/4 13:46
 */
public class GreenCar {
    //电机
    private String motor;
    //电池
    private String battery;
    //电控
    private String electronicControl;
    //品牌
    private String brand;

    /**上面必须、下面选配*/

    //是否自持自动驾驶
    private Boolean autopilot;

    public GreenCar(String motor, String battery, String electronicControl, String brand, Boolean autopilot) {
        this.motor = motor;
        this.battery = battery;
        this.electronicControl = electronicControl;
        this.brand = brand;
        this.autopilot = autopilot;
    }

    public GreenCar(String motor, String battery, String electronicControl, String brand) {
        this(motor,battery,electronicControl,brand,false);
    }

    public GreenCar() {
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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAutopilot(Boolean autopilot) {
        this.autopilot = autopilot;
    }
}
