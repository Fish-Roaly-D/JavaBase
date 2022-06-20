package com.roily.designpatterns.dpmain.facade.demo;

/**
 * @className：AssayDept
 * @author: rolyfish
 * @description: 化验科
 * @dte: 2022/6/19 23:53
 */
public class AssayDept implements IDepartment {

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
