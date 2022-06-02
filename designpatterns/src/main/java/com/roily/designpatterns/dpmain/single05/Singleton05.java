package com.roily.designpatterns.dpmain.single05;

/**
 * @version 1.0.0
 * @Description 登记式、使用静态内部类
 * @ClassName Singleton05.java
 * @author: RoilyFish
 * @date: 2022/6/2 12:39
 */
public class Singleton05 {

    public static Integer i = 10;

    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    private Singleton05() {
        System.out.println("创建" + this.getClass().getName());
    }

    public static final Singleton05 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
