package com.roily.designpatterns.dpmain.bridge.demo;

/**
 * @classname：C3p0DriverManager
 * @author: rolyfish
 * @description:
 * @date: 2022/6/27 23:08
 */

public class C3p0DriverManager extends AbstractDriverManager {

    public C3p0DriverManager(IDriver iDriver) {
        super.setIDriver(iDriver);
    }

    @Override
    void action() {
        System.out.println(this.getClass().getName()+"||"+super.getConnection() + "||做其他操作");
    }

}
