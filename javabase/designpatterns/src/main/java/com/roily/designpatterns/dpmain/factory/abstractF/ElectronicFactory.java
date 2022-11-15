package com.roily.designpatterns.dpmain.factory.abstractF;


/**
 * @version 1.0.0
 * @Description
 * @ClassName ElectronicFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 0:45
 */
public interface ElectronicFactory {

    IPhone createPhone();

    IComputer createComputer();

}
