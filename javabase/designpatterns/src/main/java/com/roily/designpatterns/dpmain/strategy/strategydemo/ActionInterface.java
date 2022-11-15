package com.roily.designpatterns.dpmain.strategy.strategydemo;

/**
 * @className：ActionInteface
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 00:50
 */
public interface ActionInterface {

    /**
     * 抽象业务
     * @param person
     */
    void doAction(Person person);

}
