package com.roily.designpatterns.dpmain.chainofresponsibility.demo;

/**
 * @className：Handler
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/18 00:28
 */
public interface Handler {
    /**
     * 校验
     */
    void doOperate(Person person);
}
