package com.roily.base.abstractandinterface.abs;

/**
 * @classname：Student
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/20 20:59
 */
public class Teacher extends AbstractPerson{

    /**
     * 子类继承抽象类，必须实现抽象方法
     *
     * 且子类拥有父类的所有字段和方法，也就是base方法
     */
    @Override
    void work() {
        System.out.println("老师 教学");
    }
}
