package com.roily.designpatterns.dpmain.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description 价格过滤器
 * @ClassName PriceFilter.java
 * @author: RoilyFish
 * @date: 2022/6/7 0:29
 */
public class PriceFilter implements IFilter {

    @Override
    public List<Car> carFilter(List<Car> carList) {
        List<Car> properCars = new ArrayList<>();
        //价格在15-35万之间
        carList.forEach(car -> {
            if (car.getPrice().compareTo(150000) >= 0 && car.getPrice().compareTo(350000) <= 0)
                properCars.add(car);
        });
        return properCars;
    }

}
