package com.roily.designpatterns.dpmain.single.factory.method;


import com.roily.designpatterns.dpmain.single.factory.simple.ElectronicProduct;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ElectronicFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 0:45
 */
public interface ElectronicFactory {
    //抽象生产产品方法
    ElectronicProduct createProduct();

}
