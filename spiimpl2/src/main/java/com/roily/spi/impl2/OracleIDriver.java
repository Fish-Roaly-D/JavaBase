package com.roily.spi.impl2;

import com.roiy.spi.IDriver;

/**
 * @Date: 2022/11/07/15:34
 * @Description:
 */
public class OracleIDriver implements IDriver {
    @Override
    public void getConn() {
        System.out.println("oracle getConn");
    }

    @Override
    public void service() {
        System.out.println("oracle service");
    }
}


