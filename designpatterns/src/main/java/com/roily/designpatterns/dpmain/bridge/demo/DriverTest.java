package com.roily.designpatterns.dpmain.bridge.demo;

import org.junit.Test;

/**
 * @classname：Test
 * @author: rolyfish
 * @description:
 * @date: 2022/6/27 23:10
 */
public class DriverTest {

    @Test
    public void test() {

        AbstractDriverManager dbcpDriverManager = new DBCPDriverManager(new MysqlDriver());
        dbcpDriverManager.action();

        System.out.println("=================");
        AbstractDriverManager c3p0DriverManager = new C3p0DriverManager(new OracleDriver());
        c3p0DriverManager.action();

    }
}
