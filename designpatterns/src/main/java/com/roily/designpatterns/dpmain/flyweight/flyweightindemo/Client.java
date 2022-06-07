package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/8 0:15
 */
public class Client {

    //享元工厂
    static FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
    public static void main(String[] args) {

        String id = "";
        for (int i = 0; i < 100000000; i++) {
            //只能创建100个飞机在缓存
            id = (int) (Math.random() * 100) + "";
            //每循环五次造个飞机
            if (i % 50 == 0)
                flyWeightFactory.createAirPlane(id);
            //获取一个随机飞机来打
            hitPlane();
            removePlane();
            id = "";
        }

    }

    //随机打飞机
    public static void hitPlane(){
        //随机获取一个飞机
        AbstractAirPlane airPlane = flyWeightFactory.getAirPlane((int) (Math.random() * 100) + "");
        if (airPlane!=null)
            airPlane.hit();
    }

    //随机将一个飞机移出屏幕
    public static void removePlane(){
        //随机获取一个飞机
        AbstractAirPlane airPlane = flyWeightFactory.getAirPlane((int) (Math.random() * 100) + "");
        if (airPlane!=null)
            airPlane.remove();
    }

}
