package com.roily.designpatterns.dpmain.bridge.demo;

/**
 * @classname：DBCPDriverManager
 * @author: rolyfish
 * @description:
 * @date: 2022/6/27 23:08
 */
public class DBCPDriverManager extends AbstractDriverManager {

    public DBCPDriverManager(IDriver iDriver) {
        super.setIDriver(iDriver);
    }

    @Override
    void action() {
        System.out.println(this.getClass().getName() + "||" + super.getConnection() + "||做其他操作");
    }

}
