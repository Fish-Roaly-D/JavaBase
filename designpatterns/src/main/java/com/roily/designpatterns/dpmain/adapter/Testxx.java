package com.roily.designpatterns.dpmain.adapter;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Testxx.java
 * @author: RoilyFish
 * @date: 2022/6/6 18:48
 */
public class Testxx {

    //执行业务，依赖软件
    public static void business(ISoftware iSoftware, MacPC macPC) {
        iSoftware.run(macPC);
    }

    public static void main(String[] args) {


        MacPC m1 = new MacPC("M1");
        MacPC intel = new MacPC("Intel");
        ArmSoft armSoft = new ArmSoft();
        X86Soft x86Soft = new X86Soft();

        //m1运行Arm架构软件没有问题
        business(armSoft, m1);
        //intel运行X86架构软件没有问题
        business(x86Soft, intel);

        /**
         * 那么现在我想要使用 M1运行X86架构的软件呢
         * 显示运行不了
         */
        business(x86Soft,m1);
    }
}
