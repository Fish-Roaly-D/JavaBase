package com.roily.designpatterns.dpmain.filter;

import java.util.List;

/**
 * @version 1.0.0
 * @Description 过滤抽象接口
 * @ClassName IFilter.java
 * @author: RoilyFish
 * @date: 2022/6/7 0:22
 */
public interface IFilter {
    //抽象过滤方法
    List<Car> carFilter(List<Car> carList);
}
