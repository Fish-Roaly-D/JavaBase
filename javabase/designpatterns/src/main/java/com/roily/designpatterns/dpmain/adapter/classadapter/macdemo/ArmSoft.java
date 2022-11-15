package com.roily.designpatterns.dpmain.adapter.classadapter.macdemo;

/**
 * @className：ArmSoft
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/14 23:29
 */
public class ArmSoft extends X86Soft implements ISoft{

    @Override
    public void rosetta() {
        System.out.println("转译");
    }
}
