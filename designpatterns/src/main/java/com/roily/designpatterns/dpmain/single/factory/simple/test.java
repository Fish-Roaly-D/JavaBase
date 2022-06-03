package com.roily.designpatterns.dpmain.single.factory.simple;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName test.java
 * @author: RoilyFish
 * @date: 2022/6/3 23:30
 */
public class test {

    @Test
    public void test(){
        Operation operationAdd = new OperationAdd();
        operationAdd.setValue01(2);
        operationAdd.setValue01(1);
        System.out.println(operationAdd.getResult());

        Operation operationSubtraction = new OperationSubtraction();
        operationSubtraction.setValue01(2);
        operationSubtraction.setValue01(1);
        System.out.println(operationSubtraction.getResult());

    }
}
