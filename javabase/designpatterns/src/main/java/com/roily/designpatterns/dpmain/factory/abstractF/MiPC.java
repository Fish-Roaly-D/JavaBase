package com.roily.designpatterns.dpmain.factory.abstractF;

/**
 * @version 1.0.0
 * @Description 小米电脑
 * @ClassName MiPC.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:46
 */
public class MiPC implements IComputer {

    @Override
    public void ProductionComputer() {
        System.out.println("生产小米电脑");
    }

}
