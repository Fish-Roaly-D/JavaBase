package com.roily.designpatterns.dpmain.decorator.simpledecorator;

/**
 * @className：IDecorator
 * @author: rolyfish
 * @description: 定义抽象装饰器
 * @dte: 2022/6/15 01:47
 */
public interface IDecorator {

    /**
     * 抽象方法命名一般和具体构建方法一致
     */
    void method();

    /**
     * 装饰抽象方法
     */
    void decorateBefore();

    /**
     * 装饰抽象方法
     */
    void decorateAfter();

}
