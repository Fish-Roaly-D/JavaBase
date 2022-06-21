package com.roily.designpatterns.dpmain.state.demo;

/**
 * @className：WaitPAy
 * @author: rolyfish
 * @description: 待支付
 * @dte: 2022/6/21 22:29
 */
public class WaitPay implements State{

    @Override
    public void doSomeThing(Context context) {

        System.out.println("当前订单处于支付状态");
        System.out.println("business。。。");
        System.out.println("订单由支付变为发货状态");
        context.setState(new Driver());
    }

}
