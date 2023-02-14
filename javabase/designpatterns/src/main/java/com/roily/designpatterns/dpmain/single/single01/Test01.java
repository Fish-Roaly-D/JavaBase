package com.roily.designpatterns.dpmain.single.single01;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    @Test
    public void testSeri() {

        // 单例
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton01 singleton02 = null;
        try
                (
                        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("D:\\" + Singleton01.class.getSimpleName())));
                ) {
            out.writeObject(singleton01);
        } catch (IOException e) {
        }
        try
                (
                        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("D:\\" + Singleton01.class.getSimpleName())))
                ) {
            singleton02 = (Singleton01) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("singleton01哈希值：" + singleton01.hashCode());
        System.out.println("singleton02哈希值：" + singleton02.hashCode());

    }

    /**
     * 测试多线程情况下会创建多个不同实例
     */
    @Test
    public void test02() {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton01.getInstance().hashCode());
            }).start();
        }
        //保证线程执行结束
        while (true) ;
    }
}
