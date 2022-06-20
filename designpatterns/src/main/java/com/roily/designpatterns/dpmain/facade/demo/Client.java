package com.roily.designpatterns.dpmain.facade.demo;

/**
 * @className：Client
 * @author: rolyfish
 * @description: 客户端、病人
 * @dte: 2022/6/20 00:03
 */
public class Client {

    public static void main(String[] args) {
        final Facade facade = new Facade();
        //看胃病
        facade.fixStomachError();
        //摔了一跤，找找毛病
        facade.fixError();
    }

}
