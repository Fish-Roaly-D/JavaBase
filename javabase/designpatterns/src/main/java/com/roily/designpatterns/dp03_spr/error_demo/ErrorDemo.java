package com.roily.designpatterns.dp03_spr.error_demo;

/**
 * @version 1.0.0
 * @Description
 * @ClassName OkDemo.java
 * @author: RoilyFish
 * @date: 2022/5/30 23:20
 */
public class ErrorDemo {
}


interface BusinessWork {

    //司机开车
    void drive();

    //后勤工作
    void backOffice();

}

class DriverWorker implements BusinessWork {

    @Override
    public void drive() {
        //司机开车
    }

    @Override
    public void backOffice() {
        //司机无需关心后勤，也需要实现，不合理
    }
}

class BackOfficeWorker implements BusinessWork {


    @Override
    public void drive() {
        //后勤工作者无需关心开车，也需要实现，不合理
    }

    @Override
    public void backOffice() {
        //后勤工作
    }
}