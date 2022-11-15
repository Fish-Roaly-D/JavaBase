package com.roily.designpatterns.dpmain.state.demo;

/**
 * @className：Driver
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/21 22:34
 */
public class Driver implements State{

    @Override
    public void doSomeThing(Context context) {
        System.out.println("当前订单处于发货状态");
        System.out.println("business。。。");
        System.out.println("订单由发货变为收货状态");
        context.setState(new Receive());
    }
}
