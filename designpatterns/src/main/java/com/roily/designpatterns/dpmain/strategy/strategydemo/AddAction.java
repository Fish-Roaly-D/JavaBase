package com.roily.designpatterns.dpmain.strategy.strategydemo;

/**
 * @className：AddAction
 * @author: rolyfish
 * @description: 添加动作
 * @dte: 2022/6/17 00:53
 */
public class AddAction implements ActionInterface{

    @Override
    public void doAction(Person person ) {
        Context.addAction(person);
    }
}
