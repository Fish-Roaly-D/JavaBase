package com.roily.designpatterns.dpmain.adapter.classadapter;

/**
 *
 * @description 目标接口（需要一个适配器，将Source中的方法进行拓展）
 * @author rolyfish
 */
public interface TargetAble {

    /**
     * 方法名称必须和Source中的方法名称相同
     */
    void method01();

    /**
     * 目标接口需要适配method02
     */
    void method02();
}
