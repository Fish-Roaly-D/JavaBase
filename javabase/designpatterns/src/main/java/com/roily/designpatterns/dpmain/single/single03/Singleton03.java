package com.roily.designpatterns.dpmain.single.single03;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Singleton03.java
 * @author: RoilyFish
 * @date: 2022/6/2 11:54
 */
public class Singleton03 {

    //在首次直接引用初始化。这个初始化可能是由于其他原因
    private static Singleton03 instance;

    static {
        try {
            instance = new Singleton03();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //定义一个静态成员变量
    static Integer i = 10;

    private Singleton03() throws InterruptedException {
        System.out.println("创建" + this.getClass().getName());
        //如果说创建这个实例需要消耗大量时间
        Thread.sleep(3000);
    }

    public static Singleton03 getInstance() {
        return instance;
    }

}
