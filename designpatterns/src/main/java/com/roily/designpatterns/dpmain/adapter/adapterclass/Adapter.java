package com.roily.designpatterns.dpmain.adapter.adapterclass;

/**
 * @version 1.0.0
 * @Description 适配类
 * @ClassName Adapter.java
 * @author: RoilyFish
 * @date: 2022/6/12 10:12
 */
public class Adapter extends Source implements TargetInterface {

    /**
     * method01 已在Source实现
     */
    @Override
    public void method02() {
        System.out.println(Adapter.class.getName());
    }

}
