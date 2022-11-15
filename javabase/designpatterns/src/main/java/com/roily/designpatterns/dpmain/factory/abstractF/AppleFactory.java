package com.roily.designpatterns.dpmain.factory.abstractF;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AppleFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:51
 */
public class AppleFactory implements ElectronicFactory {

    @Override
    public IPhone createPhone() {
        return new AppleIPhone();
    }

    @Override
    public IComputer createComputer() {
        return new ApplePC();
    }

}
