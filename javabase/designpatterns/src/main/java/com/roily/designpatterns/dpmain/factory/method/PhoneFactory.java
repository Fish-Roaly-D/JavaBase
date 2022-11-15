package com.roily.designpatterns.dpmain.factory.method;

import com.roily.designpatterns.dpmain.factory.simple.ElectronicProduct;
import com.roily.designpatterns.dpmain.factory.simple.Phone;

/**
 * @version 1.0.0
 * @Description 手机工厂
 * @ClassName PhoneFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 0:58
 */
public class PhoneFactory implements ElectronicFactory {
    @Override
    public ElectronicProduct createProduct() {
        return new Phone();
    }
}
