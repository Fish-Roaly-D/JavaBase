package com.roily.designpatterns.dpmain.adapter.adapterclass;

/**
 * @version 1.0.0
 * @Description 适配接口
 * @ClassName TargetInterface.java
 * @author: RoilyFish
 * @date: 2022/6/12 10:10
 */
public interface TargetInterface {

    //与待适配类方法名相同
    void method01();

    /**
     * 新方法
     */
    void method02();

}
