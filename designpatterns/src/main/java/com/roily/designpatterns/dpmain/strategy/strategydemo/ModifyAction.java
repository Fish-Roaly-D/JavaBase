package com.roily.designpatterns.dpmain.strategy.strategydemo;

/**
 * @className：AddAction
 * @author: rolyfish
 * @description: 修改动作
 * @dte: 2022/6/17 00:53
 */
public class ModifyAction implements ActionInterface{

    @Override
    public void doAction(Person person ) {
        Context.modifyAction(person);
    }
}
