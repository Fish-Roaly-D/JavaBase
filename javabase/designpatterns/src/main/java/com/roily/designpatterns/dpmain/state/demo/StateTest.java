package com.roily.designpatterns.dpmain.state.demo;

/**
 * @className：StateTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/21 22:38
 */
public class StateTest {
    public static void main(String[] args) {
        //一个人下单了，初始化状态为支付
        final Context context = new Context();
        context.setState(new WaitPay());
        context.getState().doSomeThing(context);
        context.getState().doSomeThing(context);
        context.getState().doSomeThing(context);
        context.getState().doSomeThing(context);

    }
}
