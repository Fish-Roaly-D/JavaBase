package com.roily.designpatterns.dpmain.adapter.objadapter;

/**
 * @className：TargetAble
 * @author: rolyfish
 * @description: 目标接口
 * @dte: 2022/6/15 00:13
 */
public interface TargetAble {


    /**
     * 和source类中的方法名称一样
     */
    void method01();

    /**
     * 目标借口可以适配method02方法
     */
    void method02();
}
