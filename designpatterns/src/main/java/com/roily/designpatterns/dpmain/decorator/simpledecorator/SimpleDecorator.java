package com.roily.designpatterns.dpmain.decorator.simpledecorator;

/**
 * @className：SimpleDecorator
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 01:49
 */
public class SimpleDecorator implements IDecorator {

    /**
     * 将具体构建组合进来
     */
    private BaseComponent baseComponent;

    public SimpleDecorator(BaseComponent baseComponent) {
        this.baseComponent = baseComponent;
    }

    @Override
    public void method() {
        this.decorateBefore();
        baseComponent.method();
        this.decorateAfter();
    }

    @Override
    public void decorateBefore() {
        System.out.println("装饰前");
    }

    @Override
    public void decorateAfter() {
        System.out.println("装饰后");
    }

}
