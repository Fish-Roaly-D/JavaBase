package com.roily.designpatterns.dpmain.decorator.transparentdecorator;

/**
 * @className：IDecorator
 * @author: rolyfish
 * @description: 抽象装饰器
 * @dte: 2022/6/15 02:12
 */
public interface IDecorator {
    /**
     * 装饰抽象方法
     */
    void decorateBefore();

    /**
     * 装饰抽象方法
     */
    void decorateAfter();
}
