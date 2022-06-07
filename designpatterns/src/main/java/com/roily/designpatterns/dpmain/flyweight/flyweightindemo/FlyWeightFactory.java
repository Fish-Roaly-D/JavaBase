package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

import java.util.HashMap;
import java.util.Random;

/**
 * @version 1.0.0
 * @Description 享元工厂
 * @ClassName FlyWeightFactory.java
 * @author: RoilyFish
 * @date: 2022/6/8 0:08
 */
public class FlyWeightFactory {

    private HashMap<String, AbstractAirPlane> map = new HashMap<>();

    private int limit = 100;

    //创建一个飞机
    AbstractAirPlane createAirPlane(String id) {

        if (map.size() >= 100) {
            System.out.println("创建不了了");
            return null;
        }
        AbstractAirPlane plane = map.get(id);
        if (plane == null) {
            AirPlane create = new AirPlane(id, "波音747", (int) ((Math.random()) * 4 + 1));
            map.put(create.getId(), create);
            System.out.println("创建"+create);
            return create;
        }
        return plane;

    }


    //获取一个飞机
    AbstractAirPlane getAirPlane(String id) {
        //能用的飞机
        AbstractAirPlane abstractAirPlane = map.get(id);
        if (abstractAirPlane != null && abstractAirPlane.getLifeValue() > 0)
            return abstractAirPlane;
        return null;
    }

}
