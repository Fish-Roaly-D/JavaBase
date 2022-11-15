package com.roily.designpatterns.dpmain.factory.abstractF;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ApplePC.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:47
 */
public class ApplePC implements IComputer {

    @Override
    public void ProductionComputer() {
        System.out.println("生产苹果电脑");
    }

}
