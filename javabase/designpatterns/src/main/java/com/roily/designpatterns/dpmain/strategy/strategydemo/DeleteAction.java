package com.roily.designpatterns.dpmain.strategy.strategydemo;

/**
 * @className：AddAction
 * @author: rolyfish
 * @description: 删除动作
 * @dte: 2022/6/17 00:53
 */
public class DeleteAction implements ActionInterface{

    @Override
    public void doAction(Person person ) {
        Context.deleteAction(person);
    }
}
