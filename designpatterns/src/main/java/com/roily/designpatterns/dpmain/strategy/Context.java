package com.roily.designpatterns.dpmain.strategy;

/**
 * @className：Context
 * @author: rolyfish
 * @description: 策略上下文，策略转发器
 * @dte: 2022/6/17 00:18
 */
public class Context {

    /**
     * 将需要转发的策略类组合进来
     */
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doForWard(){
        strategy.doBusiness();
    }

}
