package com.roily.designpatterns.dpmain.bridge.demo;

import lombok.Data;

/**
 * @classname：MysqlDriver
 * @author: rolyfish
 * @description: mysql驱动
 * @date: 2022/6/27 23:03
 */
@Data
public class MysqlDriver implements IDriver {

    @Override
    public String getConnection() {
        System.out.println(this.getClass().getName() + "获取链接");
        return this.getClass().getName();
    }

    @Override
    public void resolve() {
        System.out.println(this.getClass().getName() + "释放链接");
    }
}
