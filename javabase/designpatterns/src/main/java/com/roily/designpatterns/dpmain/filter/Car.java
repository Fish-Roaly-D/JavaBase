package com.roily.designpatterns.dpmain.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0.0
 * @Description 车
 * @ClassName Car.java
 * @author: RoilyFish
 * @date: 2022/6/7 0:15
 */
@Data
@AllArgsConstructor
public class Car {

    //品牌
    String brand;

    //是否新能源
    Boolean isGreen;

    //类型SUV、轿跑
    String type;

    //等级 A、b、c级
    String grade;

    //等级 A、b、c级
    Integer price;

}
