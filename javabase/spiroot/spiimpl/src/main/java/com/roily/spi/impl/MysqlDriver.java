package com.roily.spi.impl;

import com.roiy.spi.IDriver;

/**
 * @Date: 2022/11/07/11:31
 * @Description:
 */
public class MysqlDriver implements IDriver {

    @Override
    public void getConn() {
        System.out.println("mysql getConn");
    }

    @Override
    public void service() {
        System.out.println("mysql service");

    }
}
