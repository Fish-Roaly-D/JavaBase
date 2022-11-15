package com.roily.designpatterns.dpmain.decorator.simple;

import lombok.Data;

/**
 * @version 1.0.0
 * @Description 抽象的装饰器
 * @ClassName AbstractDecorator.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:06
 */
@Data
public abstract class AbstractDecorator {

    //将需要装饰的对象，组合进来
    private BaseCar baseCar;

    public AbstractDecorator(BaseCar baseCar) {
        this.baseCar = baseCar;
    }

    //拓展抽象方法
    abstract void expand();
}
