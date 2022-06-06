package com.roily.designpatterns.dpmain.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description
 * @ClassName OtherFilter.java
 * @author: RoilyFish
 * @date: 2022/6/7 0:33
 */
public class OtherFilter implements IFilter {


    @Override
    public List<Car> carFilter(List<Car> carList) {
        List<Car> properCars = new ArrayList<>();
        //新能源  B级车
        carList.forEach(car -> {
            if (car.getGrade().equals("B") && car.getIsGreen())
                properCars.add(car);
        });
        return properCars;
    }
}
