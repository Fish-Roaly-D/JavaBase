package com.roily.designpatterns.dpmain.state;

/**
 * @className：State
 * @author: rolyfish
 * @description: 状态接口
 * @dte: 2022/6/21 21:33
 */
public interface State {
    /**
     * 某个状态对应需要执行的方法
     * 持有上下文对象，可在特定情况切换状态
     * @param context
     */
    void doAction(Context context);
}
