package com.roily.designpatterns.dpmain.single.factory.method;

/**
 * @version 1.0.0
 * @Description
 * @ClassName OperationAddFactory.java
 * @author: RoilyFish
 * @date: 2022/6/3 23:54
 */
public class OperationAddFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
