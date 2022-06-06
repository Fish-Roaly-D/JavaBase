package com.roily.designpatterns.dpmain.bridge;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/6 19:49
 */
public class Client {

    @Test
    public void test01() {

        Brand miPC = new MI(new MIPC());
        miPC.name();

        Brand miPhone = new MI(new MIPhone());
        miPhone.name();


        Brand applePC = new Apple(new ApplePC());
        applePC.name();

        Brand applePhone = new Apple(new ApplePhone());
        applePhone.name();


    }
}
