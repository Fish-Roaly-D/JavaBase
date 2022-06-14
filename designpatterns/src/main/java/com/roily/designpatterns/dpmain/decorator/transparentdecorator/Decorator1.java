package com.roily.designpatterns.dpmain.decorator.transparentdecorator;

/**
 * @className：Decorator1
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/15 02:14
 */
public class Decorator1 implements IComponent, IDecorator {

    /**
     * 组合构件
     */
    private IComponent iComponent;

    public Decorator1(IComponent iComponent) {
        this.iComponent = iComponent;
    }

    @Override
    public void method() {
        this.decorateBefore();
        iComponent.method();
        this.decorateAfter();
    }

    @Override
    public void decorateBefore() {
        System.out.println(this.getClass().getName() + "<>" + "before");
    }

    @Override
    public void decorateAfter() {
        System.out.println(this.getClass().getName() + "<>" + "before");
    }
}
