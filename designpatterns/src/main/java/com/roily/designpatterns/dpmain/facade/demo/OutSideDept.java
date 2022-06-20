package com.roily.designpatterns.dpmain.facade.demo;

/**
 * @className：OutSideDept
 * @author: rolyfish
 * @description: 外科
 * @dte: 2022/6/19 23:48
 */
public class OutSideDept implements IDepartment{

    @Override
    public void doWork() {
        System.out.println(this.getClass().getName() + "do work");
    }

    /**
     * 定义提供给内部系统调用的方法，对外隐藏
     */
    public void doOther() {
        System.out.println(this.getClass().getName() + "do other");
    }

}
