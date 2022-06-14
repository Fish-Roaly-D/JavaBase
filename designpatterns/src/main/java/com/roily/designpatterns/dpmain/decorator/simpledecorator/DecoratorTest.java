package com.roily.designpatterns.dpmain.decorator.simpledecorator;

import org.junit.Test;

/**
 * @className：DecoratorTest
 * @author: rolyfish
 * @description: 装饰器模式测试
 * @dte: 2022/6/15 01:54
 */
public class DecoratorTest {

    @Test
    public void decoratorTest(){

        //具体构建
        BaseComponent baseComponent = new BaseComponent();
        //定义装饰器
        IDecorator simpleDecorator = new SimpleDecorator(baseComponent);
        simpleDecorator.method();
    }

}
