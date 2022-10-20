package com.roily.abstractandinterface.interfaceD;

/**
 * @classname：Singer
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/20 21:08
 */
public class Singer implements IPersonHobby{

    @Override
    public void work() {
        System.out.println("开演唱会");
    }

    @Override
    public void hobby() {
        System.out.println("喜欢唱歌");
    }
}
