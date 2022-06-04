package com.roily.designpatterns.dpmain.factory.abstractF;

/**
 * @version 1.0.0
 * @Description 小米代工厂
 * @ClassName MiFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:49
 */
public class MiFactory implements ElectronicFactory {
    @Override
    public IPhone createPhone() {
        return new MiIPhone();
    }

    @Override
    public IComputer createComputer() {
        return new MiPC();
    }


}
