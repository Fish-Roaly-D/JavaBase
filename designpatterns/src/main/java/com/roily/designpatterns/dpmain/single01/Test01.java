package com.roily.designpatterns.dpmain.single01;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Test01.java
 * @author: RoilyFish
 * @date: 2022/6/2 11:09
 */
public class Test01 {

    /**
     * 多次获取同一个实例
     */
    @Test
    public void test01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(Singleton01.getInstance().hashCode());
        System.out.println(Singleton01.getInstance().hashCode());

        //反射，获取构造器
        Constructor<Singleton01> declaredConstructor = Singleton01.class.getDeclaredConstructor();
        //破坏私有属性
        declaredConstructor.setAccessible(true);
        //创建实例
        Singleton01 singleton01 = declaredConstructor.newInstance();

        System.out.println(singleton01.hashCode());

    }

    /**
     * 测试多线程情况下会创建多个不同实例
     */
    @Test
    public void test02(){

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton01.getInstance().hashCode());
            }).start();
        }
        //保证线程执行结束
        while (true);
    }
}
