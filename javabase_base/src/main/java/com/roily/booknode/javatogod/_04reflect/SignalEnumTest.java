package com.roily.booknode.javatogod._04reflect;

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
 * @classname：SignalEnumTest
 * @author: rolyfish
 * @description:
 * @date: 2022/8/26 01:45
 */
public class SignalEnumTest {

    @Test
    public void test1() {

        System.out.println(SignalEnum.SIGNAL_ENUM == SignalEnum.SIGNAL_ENUM);

    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        final Constructor<? extends SignalEnum> declaredConstructor = SignalEnum.SIGNAL_ENUM.getClass().getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        final SignalEnum signalEnum = declaredConstructor.newInstance("signalEnum", 2);
        System.out.println(signalEnum == SignalEnum.SIGNAL_ENUM);
        System.out.println(SignalEnum.SIGNAL_ENUM);
        System.out.println(signalEnum);
    }


    @Test
    public void testx() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        final SignalEnum signalEnum = SignalEnum.SIGNAL_ENUM;
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File(filePath, "object2.txt")))) {
            //将instance写入文件
            objectOutputStream.writeObject(signalEnum);
            objectOutputStream.flush();
        } catch (IOException e) {
        }
    }

    @Test
    public void testy() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        final SignalEnum signalEnum = SignalEnum.SIGNAL_ENUM;
        SignalEnum signalEnum2 = null;
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(new File(filePath, "object2.txt")))) {
            //将instance写入文件
            signalEnum2 = (SignalEnum) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        System.out.println(signalEnum == signalEnum2);
        System.out.println(signalEnum);
        System.out.println(signalEnum2);
    }

}
