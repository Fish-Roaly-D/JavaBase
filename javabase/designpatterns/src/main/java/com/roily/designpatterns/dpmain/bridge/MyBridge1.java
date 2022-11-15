package com.roily.designpatterns.dpmain.bridge;

/**
 * @className：MyBridge
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/15 19:27
 */
public class MyBridge1 extends AbstractBridge{

    /**
     * 根据设置的Isource执行对应方法
     */
    @Override
    public void method(){
        System.out.println("MyBridge1");
        super.method();
    }
}
