package com.roily.booknode.javatogod._06serializable;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @classname：Test
 * @author: rolyfish
 * @description: 测试可序列化类的子类是否支持序列化
 * @date: 2022/8/30 00:27
 */
public class TestExtends {

    @Test
    public void test1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        final ClassParent classParent = new ClassParent();
        classParent.setValue1("Parent");
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, classParent.getClass().getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classParent);
            objectOutputStream.flush();
        } catch (IOException e) {
        }
    }

    /**
     * 想要序列化父类属性，父类也需要实现序列化接口
     */
    @Test
    public void test2() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        final ClassSon classSon = new ClassSon();
        classSon.setValue1("Parent");
        classSon.setValue2("Son");
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, classSon.getClass().getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classSon);
            objectOutputStream.flush();
        } catch (IOException e) {
        }

        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(new File(filePath, classSon.getClass().getSimpleName() + ".txt")))) {
            final Object o = objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        final ClassSonSon classSonSon = new ClassSonSon();
        classSonSon.setValue("SonSon");
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, classSonSon.getClass().getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classSonSon);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";

        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(new File(filePath, ClassSonSon.class.getSimpleName() + ".txt")))) {
            final ClassSonSon classSonSon = (ClassSonSon) objectInputStream.readObject();
            System.out.println(classSonSon);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassNoSerializable() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        final ClassNoSerializable classNoSerializable = new ClassNoSerializable();
        classNoSerializable.setValue("xx");
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, ClassNoSerializable.class.getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classNoSerializable);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassNoSerializablex() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(new File(filePath, ClassNoSerializable.class.getSimpleName() + ".txt")))) {
            final ClassNoSerializable classNoSerializable = (ClassNoSerializable) objectInputStream.readObject();
            System.out.println(classNoSerializable);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}