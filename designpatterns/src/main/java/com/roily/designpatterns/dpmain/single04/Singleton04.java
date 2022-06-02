package com.roily.designpatterns.dpmain.single04;

/**
 * @version 1.0.0
 * @Description 双重校验锁
 * @ClassName Singleton04.java
 * @author: RoilyFish
 * @date: 2022/6/2 12:08
 */
public class Singleton04 {

    //使用volatile，及时通知其他线程，单例被创建了，请更新
    private volatile static Singleton04 singleton;

    private Singleton04() {
        System.out.println("创建" + this.getClass().getName());
    }

    public static Singleton04 getSingleton() {
        //等于空时加锁，避免重复创建单例
        if (singleton == null) {
            synchronized (Singleton04.class) {
                if (singleton == null) {
                    singleton = new Singleton04();
                }
            }
        }
        return singleton;
    }

}
