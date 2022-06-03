package com.roily.designpatterns.dpmain.single.factory.simple;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 简单工厂类
 * @ClassName OperationFactory.java
 * @author: RoilyFish
 * @date: 2022/6/3 23:39
 */
public class OperationFactory {

    //也可以传递字符串。。add···
    public static Operation createOperation(Class<? extends Operation> operation) {
        try {
            return operation.newInstance();
        } catch (Exception e){
            return null;
        }
    }

    @Test
    public void test(){

        Operation operation = OperationFactory.createOperation(OperationAdd.class);
        assert operation != null;
        operation.setValue01(2);
        operation.setValue01(1);
        System.out.println(operation.getResult());
    }
}
