package com.roily.designpatterns.dpmain.decorator.transparentdecorator;

/**
 * @className：Component01
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 02:12
 */
public class Component01 implements IComponent {
    @Override
    public void method() {
        System.out.println(this.getClass().getName());
    }
}
