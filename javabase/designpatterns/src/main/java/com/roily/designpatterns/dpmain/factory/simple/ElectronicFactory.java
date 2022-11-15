package com.roily.designpatterns.dpmain.factory.simple;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ElectronicFactory.java
 * @author: RoilyFish
 * @date: 2022/6/4 0:45
 */
public class ElectronicFactory {

    //工厂造产品
    public static ElectronicProduct createProduct(String type) {
        ElectronicProduct temp = null;
        switch (type) {
            case "phone":
                temp = new Phone();
                break;
            case "computer":
                temp = new Computer();
                break;
            default:
                ;
        }
        return temp;
    }

    public ElectronicProduct createPhone(){
        return new Phone();
    }
    public ElectronicProduct createComputer(){
        return new Computer();
    }

    @Test
    public void Client() {
        ElectronicProduct phone = ElectronicFactory.createProduct("phone");
        ElectronicProduct computer = ElectronicFactory.createProduct("computer");
    }

}
