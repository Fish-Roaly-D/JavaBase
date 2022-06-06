package com.roily.designpatterns.dpmain.bridge;

/**
 * @version 1.0.0
 * @Description 品牌抽象类
 * @ClassName Brand.java
 * @author: RoilyFish
 * @date: 2022/6/6 19:44
 */
public abstract class Brand {

    //聚合产品
    protected ElectronicProduct electronicProduct;

    protected Brand(ElectronicProduct electronicProduct) {
        this.electronicProduct = electronicProduct;
    }

    abstract void name();

}
