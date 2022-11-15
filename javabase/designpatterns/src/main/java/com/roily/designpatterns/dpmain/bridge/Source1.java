package com.roily.designpatterns.dpmain.bridge;

/**
 * @className：Source1
 * @author: rolyfish
 * @description: 实现类1
 * @dte: 2022/6/15 19:23
 */
public class Source1 implements ISource{

    @Override
    public void method1() {
        System.out.println(this.getClass().getName());
    }

}
