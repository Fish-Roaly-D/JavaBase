package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

/**
 * @className：IConnection
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 21:21
 */
public interface IConnection {
    /**
     * 获取用户姓名
     * @return
     */
    String getUserName();

    /**
     * 获取用户姓名
     * @return
     */
    String getPassWord();

    /**
     * 释放资源
     */
    void release();
}
