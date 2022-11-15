package com.roily.designpatterns.dpmain.bridge;

/**
 * @className：Source2
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/15 19:24
 */
public class Source2 implements ISource{
    @Override
    public void method1() {
        System.out.println(this.getClass().getName());
    }
}
