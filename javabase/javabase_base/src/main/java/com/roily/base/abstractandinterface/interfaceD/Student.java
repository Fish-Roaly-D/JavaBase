package com.roily.base.abstractandinterface.interfaceD;

/**
 * @classname：Student
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/20 20:59
 */
public class Student implements IPerson {

    /**
     * 具体类 实现接口 必须实现抽象方法
     */
    @Override
    public void work() {
        System.out.println("学生 学习");
    }
}
