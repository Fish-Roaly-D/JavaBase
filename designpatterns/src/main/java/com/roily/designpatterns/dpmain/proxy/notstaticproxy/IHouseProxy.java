package com.roily.designpatterns.dpmain.proxy.notstaticproxy;

/**
 * @className：IHouseProxy
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/18 22:07
 */
public interface IHouseProxy {

    /**
     * 中介前置动作
     */
    void prevWork();

    /**
     * 中介后置动作
     */
    void nextWork();


}
