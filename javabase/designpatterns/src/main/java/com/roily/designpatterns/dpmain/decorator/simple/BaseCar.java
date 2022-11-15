package com.roily.designpatterns.dpmain.decorator.simple;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version 1.0.0
 * @Description
 * @ClassName BaseCar.java
 * @author: RoilyFish
 * @date: 2022/6/7 13:05
 */
@Data
@AllArgsConstructor
public class BaseCar {

    private String name;

    public void run() {
        System.out.println(this.getName() + "汽车会跑");
    }
}
