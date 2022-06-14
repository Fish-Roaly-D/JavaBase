package com.roily.designpatterns.dpmain.adapter.classadapter;

/**
 * @description 适配器
 * @author rolyfish
 */
public class Adapter extends Source implements TargetAble{

    /**
     * method01在继承Source中已经实现了，现在只要实现method02就行
     */

    @Override
    public void method02() {
        System.out.println("method02");
    }
}
