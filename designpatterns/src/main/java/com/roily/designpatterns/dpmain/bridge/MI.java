package com.roily.designpatterns.dpmain.bridge;

/**
 * @version 1.0.0
 * @Description
 * @ClassName MI.java
 * @author: RoilyFish
 * @date: 2022/6/6 19:46
 */
public class MI extends Brand {

    public MI(ElectronicProduct electronicProduct) {
        super(electronicProduct);
    }

    @Override
    void name() {
        System.out.println("小米品牌");
        electronicProduct.name();
    }
}
