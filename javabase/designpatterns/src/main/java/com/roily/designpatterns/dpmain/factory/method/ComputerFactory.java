package com.roily.designpatterns.dpmain.factory.method;

import com.roily.designpatterns.dpmain.factory.simple.Computer;
import com.roily.designpatterns.dpmain.factory.simple.ElectronicProduct;

/**
 * @version 1.0.0
 * @Description 电脑工厂
 * @ClassName ComputerFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 0:59
 */
public class ComputerFactory implements ElectronicFactory {
    @Override
    public ElectronicProduct createProduct() {
        return new Computer();
    }
}
