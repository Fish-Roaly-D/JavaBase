package com.roily.designpatterns.dpmain.bridge.demo;

/**
 * @className：IDriver
 * @author: rolyfish
 * @description: 自定义数据库驱动抽象接口
 * @dte: 2022/6/27 23:01
 */
public interface IDriver {

    /**
     * 获取链接
     * @return
     */
    String getConnection();

    /**
     * 释放链接
     */
    void resolve();
}
