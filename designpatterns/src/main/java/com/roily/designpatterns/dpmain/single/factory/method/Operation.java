package com.roily.designpatterns.dpmain.single.factory.method;

import lombok.Data;

/**
 * @version 1.0.0
 * @Description 数学运算抽象类
 * @ClassName Operation.java
 * @author: RoilyFish
 * @date: 2022/6/3 23:25
 */
@Data
public abstract class Operation {

    private int value01;
    private int value02;

    //计算的抽象方法
    abstract int getResult();
}

//加法
class OperationAdd extends Operation {

    @Override
    int getResult() {
        return getValue01() + getValue02();
    }
}

//减法
class OperationSubtraction extends Operation {

    @Override
    int getResult() {
        return getValue01() - getValue02();
    }

}
