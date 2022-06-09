package com.roily.designpatterns.dpmain.proxy.cglibproxy;

/**
 * @version 1.0.0
 * @Description 真实对象  被代理的对象
 * @ClassName Obj.java
 * @author: RoilyFish
 * @date: 2022/6/9 23:50
 */
public class Obj {

    /**
     * 定义两个方法
     * 一个是普通方法，一个是被final修饰的方法
     */
    final public void doSomeThing() {
        System.out.println("doSomeThing");
    }

    public void doOtherThing() {
        System.out.println("doOtherThing");
    }

}
