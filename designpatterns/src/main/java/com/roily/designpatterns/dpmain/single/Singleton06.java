package com.roily.designpatterns.dpmain.single;

/**
 * @version 1.0.0
 * @Description 枚举类的实例天生为单例
 * @ClassName Singleton06.java
 * @author: RoilyFish
 * @date: 2022/6/2 12:47
 */
public enum Singleton06 {
    //枚举实例，天生单例
    INSTANCE;

    private Singleton06() {
        System.out.println("创建" + this.getClass().getName());
    }
}
