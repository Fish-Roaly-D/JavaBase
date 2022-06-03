package com.roily.designpatterns.dpmain.single.factory.method;

import com.roily.designpatterns.dpmain.single.factory.simple.OperationFactory;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName test.java
 * @author: RoilyFish
 * @date: 2022/6/3 23:57
 */
public class test {

    @Test
    public void test(){

        IFactory operationAddFactory = new OperationAddFactory();
        Operation operation = operationAddFactory.createOperation();
        operation.setValue01(2);
        operation.setValue02(1);
        System.out.println(operation.getResult());

        IFactory operationSubtractionFactory = new OperationSubtractionFactory();
        Operation operationx = operationSubtractionFactory.createOperation();
        operationx.setValue01(2);
        operationx.setValue02(1);
        System.out.println(operationx.getResult());

    }

}
