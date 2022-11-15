package com.roily.designpatterns.dpmain.strategy;

import org.junit.Test;

/**
 * @className：StrategyTest
 * @author: rolyfish
 * @description: 策略模式测试类
 * @dte: 2022/6/17 00:22
 */
public class StrategyTest {

    @Test
    public void test() {

        Context context1 = new Context(new StrategyImpl1());
        context1.doForWard();
        Context context2 = new Context(new StrategyImpl2());
        context2.doForWard();
    }
}