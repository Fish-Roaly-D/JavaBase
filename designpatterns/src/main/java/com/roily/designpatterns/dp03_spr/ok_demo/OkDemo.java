package com.roily.designpatterns.dp03_spr.ok_demo;

public class OkDemo {
}

interface BusinessWork {

    void sign();

}

interface DriverBusiness extends BusinessWork {

    //司机开车
    void drive();

}

interface BackOfficeBusiness extends BusinessWork {
    //后勤工作
    void backOffice();
}

class DriverWorker implements DriverBusiness {

    @Override
    public void drive() {
        //司机开车
    }

    @Override
    public void sign() {
        //打卡签到
    }
}

class BackOfficeWorker implements BackOfficeBusiness {
    @Override
    public void backOffice() {
        //后勤工作
    }

    @Override
    public void sign() {
        //打卡签到
    }
}