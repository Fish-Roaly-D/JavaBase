package com.roily.designpatterns.dpmain.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description 客户端
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/7 0:23
 */
public class Client {

    private static List<Car> cars = new ArrayList<>();
    private static PriceFilter priceFilter = new PriceFilter();
    private static OtherFilter otherFilter = new OtherFilter();


    static {
        cars.add(new Car("BYD", false, "轿跑", "A", 300000));
        cars.add(new Car("BYD", false, "SUV", "B", 100000));
        cars.add(new Car("BYD", true, "轿跑", "C", 200000));
        cars.add(new Car("BYD", false, "轿跑", "A", 300000));
        cars.add(new Car("BYD", true, "SUV", "A", 100000));
        cars.add(new Car("BYD", false, "SUV", "C", 300000));
        cars.add(new Car("BYD", true, "轿跑", "A", 400000));
        cars.add(new Car("TSL", true, "轿跑", "C", 300000));
        cars.add(new Car("TSL", true, "SUV", "A", 100000));
        cars.add(new Car("TSL", true, "轿跑", "C", 200000));
        cars.add(new Car("TSL", true, "轿跑", "B", 300000));
        cars.add(new Car("TSL", true, "SUV", "B", 100000));
        cars.add(new Car("TSL", true, "SUV", "B", 300000));
        cars.add(new Car("TSL", true, "轿跑", "B", 400000));
        cars.add(new Car("蔚来", false, "轿跑", "B", 300000));
        cars.add(new Car("蔚来", false, "SUV", "A", 100000));
        cars.add(new Car("蔚来", true, "轿跑", "A", 200000));
        cars.add(new Car("蔚来", false, "轿跑", "A", 300000));
        cars.add(new Car("蔚来", true, "SUV", "B", 100000));
        cars.add(new Car("蔚来", true, "SUV", "A", 300000));
        cars.add(new Car("蔚来", true, "轿跑", "A", 400000));
    }

    public static List<Car> doFilter() {
        List<Car> cars = priceFilter.carFilter(Client.cars);
        List<Car> cars1 = otherFilter.carFilter(cars);
        return cars;
    }

    public static void main(String[] args) {
        List<Car> cars = doFilter();

        cars.forEach(System.out::println);
    }

}
