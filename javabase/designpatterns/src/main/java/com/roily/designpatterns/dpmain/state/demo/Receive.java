package com.roily.designpatterns.dpmain.state.demo;

/**
 * @className：Driver
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/21 22:34
 */
public class Receive implements State{

    @Override
    public void doSomeThing(Context context) {
        System.out.println("当前订单处于收货状态");
        System.out.println("business。。。");
        System.out.println("订单由收货变为完成状态");
        context.setState(new Finish());
    }
}
