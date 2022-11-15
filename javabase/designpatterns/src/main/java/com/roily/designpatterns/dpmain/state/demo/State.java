package com.roily.designpatterns.dpmain.state.demo;

/**
 * @className：State
 * @author: rolyfish
 * @description: 订单状态抽象
 * @dte: 2022/6/21 22:28
 */
public interface State {

    /**
     * 每个状态需要做什么
     * @param context
     */
    void doSomeThing(Context context);
}
