package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

import lombok.Data;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AirPlane.java
 * @author: RoilyFish
 * @date: 2022/6/7 23:56
 */
public class AirPlane extends AbstractAirPlane{

    public AirPlane(String id, String typeName, Integer lifeValue) {
        super(id, typeName, lifeValue);
    }
}
