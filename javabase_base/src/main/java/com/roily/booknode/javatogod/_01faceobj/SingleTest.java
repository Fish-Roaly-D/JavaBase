package com.roily.booknode.javatogod._01faceobj;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @classname：SingleTest
 * @author: rolyfish
 * @description:
 * @date: 2022/8/26 01:31
 */
public class SingleTest {

    @Test
    public void testSingle() {
        final SingleDemo instance1 = SingleDemo.getInstance();
        final SingleDemo instance2 = SingleDemo.getInstance();
        System.out.println(instance1 == instance2);
    }

    @Test
    public void testSingle2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final SingleDemo instance1 = SingleDemo.getInstance();

        final Constructor<? extends SingleDemo> declaredConstructor = instance1.getClass().getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        final SingleDemo singleDemo = declaredConstructor.newInstance(null);
        System.out.println(instance1 == singleDemo);
    }

    @Test
    public void test1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        final SingleDemo instance1 = SingleDemo.getInstance();
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath, "object.txt")))) {
            //将instance写入文件
            objectOutputStream.writeObject(instance1);
            objectOutputStream.flush();
        } catch (IOException e) {
        }
    }

    @Test
    public void test2() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        final SingleDemo instance1 = SingleDemo.getInstance();
        SingleDemo sngleDemo = null;
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(filePath, "object.txt")))) {
            //将instance写入文件
            sngleDemo = (SingleDemo) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        System.out.println(sngleDemo == instance1);
        System.out.println(sngleDemo);
        System.out.println(instance1);
    }


}
