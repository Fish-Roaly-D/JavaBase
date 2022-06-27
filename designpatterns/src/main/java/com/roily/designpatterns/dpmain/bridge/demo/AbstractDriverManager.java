package com.roily.designpatterns.dpmain.bridge.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * @classname：AbstractDriverManager
 * @author: rolyfish
 * @description: 抽象的驱动管理类
 * @date: 2022/6/27 23:05
 */
@Getter
@Setter
abstract class AbstractDriverManager {
    /**
     * 将驱动组合进来，并提供setter和getter方法
     */
    private IDriver iDriver;

    public String getConnection(){
        return iDriver.getConnection();
    }

    /**
     * 一些其他操作
     */
    abstract void action();

}
