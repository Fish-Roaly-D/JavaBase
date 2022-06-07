package com.roily.designpatterns.dpmain.decorator.transparent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @version 1.0.0
 * @Description
 * @ClassName SimpleCar.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:52
 */
@Data
@AllArgsConstructor
public class SimpleCar implements BaseCar {

    String name;

    @Override
    public void run() {
        System.out.println(this.name+"汽车会跑！");
    }
}
