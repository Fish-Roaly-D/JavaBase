package com.roily.designpatterns.dpmain.strategy;

/**
 * 策略角色二
 * @author rolyfish
 */
public class StrategyImpl2 implements Strategy{

    @Override
    public void doBusiness() {
        System.out.println("调用："+this.getClass().getName());
    }

}
