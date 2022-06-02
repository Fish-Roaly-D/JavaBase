package com.roily.designpatterns.dpmain.single;

/**
 * @version 1.0.0
 * @Description 懒汉式、非线程安全、lazy loading
 * @ClassName Singleton01.java
 * @author: RoilyFish
 * @date: 2022/6/2 11:01
 */
public class Singleton01 {

    private static Singleton01 instance;

    //构造器私有化
    private Singleton01() {
        System.out.println("创建" + this.getClass().getName());
    }
    //提供外部访问实例方法
    public static Singleton01 getInstance() {
        if (instance == null){
            instance = new Singleton01();
        }
        return instance;
    }
}
