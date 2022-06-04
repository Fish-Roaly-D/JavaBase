package com.roily.designpatterns.dpmain.factory.abstractF;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName test.java
 * @author: RoilyFish
 * @date: 2022/6/4 1:52
 */
public class test {


    @Test
    public void test(){

        ElectronicFactory miFactory = new MiFactory();
        IPhone miPhone =  miFactory.createPhone();
        miPhone.ProductionPhone();
        IComputer miComputer = miFactory.createComputer();
        miComputer.ProductionComputer();

        ElectronicFactory appleFactory = new AppleFactory();
        IPhone applePhone =  appleFactory.createPhone();
        applePhone.ProductionPhone();
        IComputer appleComputer = appleFactory.createComputer();
        appleComputer.ProductionComputer();

    }

}
