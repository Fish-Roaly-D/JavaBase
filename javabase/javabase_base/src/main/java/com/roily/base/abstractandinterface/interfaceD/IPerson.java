package com.roily.base.abstractandinterface.interfaceD;

/**
 * @className：IPerson
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/10/20 20:56
 */
public interface IPerson {

    /**
     * 抽像为接口的话
     */
    void work();

    /**
     * 接口中可以有默认方法，default  这是一个特性  不用太关心
     */
    default void base(){
        System.out.println("吃喝啦撒");
    }
}
