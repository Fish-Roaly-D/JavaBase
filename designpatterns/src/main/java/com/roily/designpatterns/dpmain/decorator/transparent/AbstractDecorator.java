package com.roily.designpatterns.dpmain.decorator.transparent;

import lombok.Data;

/**
 * @version 1.0.0
 * @Description 抽象的装饰器
 * @ClassName AbstractDecorator.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:06
 */
@Data
public abstract class AbstractDecorator implements BaseCar {

    //将需要装饰的对象，组合进来
    private BaseCar baseCar;

    @Override
    public void run() {
        baseCar.run();
    }
}
