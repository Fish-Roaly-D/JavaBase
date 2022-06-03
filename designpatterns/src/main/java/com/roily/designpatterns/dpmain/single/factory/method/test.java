package com.roily.designpatterns.dpmain.single.factory.method;

import com.roily.designpatterns.dpmain.single.factory.simple.ElectronicProduct;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 测试
 * @ClassName test.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:01
 */
public class test {

    @Test
    public void test(){
        ElectronicFactory computerFactory = new ComputerFactory();
        ElectronicProduct computer = computerFactory.createProduct();

        ElectronicFactory phoneFactory = new PhoneFactory();
        ElectronicProduct phone = phoneFactory.createProduct();
    }
}
