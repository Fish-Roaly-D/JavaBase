package com.roily.booknode.javatogod._01faceobj.javakeywords.abouttransient;

import lombok.Data;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @classname：TransientTest
 * @author: rolyfish
 * @description:
 * @date: 2022/8/1 23:31
 */
public class TransientTest {
    String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";

    @Test
    public void test1() throws IOException {


        final TransientTestClass transientTestClass = new TransientTestClass();
        transientTestClass.setName("element");
        transientTestClass.setStr("element");
        transientTestClass.setValue(123);
        //序列化到文件
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File(filePath, transientTestClass.getClass().getName())));
        objectOutputStream.writeObject(transientTestClass);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * 读出来，使用对象接收看看
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {

        final ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(new File(filePath, TransientTestClass.class.getName())));

        TransientTestClass transientTestClass = (TransientTestClass) objectInputStream.readObject();

        System.out.println(transientTestClass);
    }

}

@Data
class TransientTestClass implements Serializable {

    private static final long serialVersionUID = 9167810647635375505L;

    private String str;

    private Integer value;

    private transient String name;

    private transient int age;

}