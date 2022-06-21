package com.roily.designpatterns.dpmain.state.demo;

/**
 * @className：Driver
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/21 22:34
 */
public class Finish implements State{

    @Override
    public void doSomeThing(Context context) {
        System.out.println("当前订单处于完成状态");
        System.out.println("完成结束");
    }
}
