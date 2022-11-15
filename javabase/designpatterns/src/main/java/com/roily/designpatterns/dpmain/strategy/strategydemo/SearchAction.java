package com.roily.designpatterns.dpmain.strategy.strategydemo;

/**
 * @className：AddAction
 * @author: rolyfish
 * @description: 查询动作
 * @dte: 2022/6/17 00:53
 */
public class SearchAction implements ActionInterface{

    @Override
    public void doAction(Person person ) {
        Context.searchAction(person);
    }
}
