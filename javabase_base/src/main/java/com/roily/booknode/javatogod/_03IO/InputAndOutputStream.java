package com.roily.booknode.javatogod._03IO;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

/**
 * @classname：InputAndOutputStream
 * @author: rolyfish
 * @description: 字节输入输出流
 * @date: 2022/8/22 23:07
 */
public class InputAndOutputStream {

    @Test
    public void inputStreamTest1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/test.txt";
        try (FileInputStream fin = new FileInputStream(filePath)) {
            //跳过指定长度字符
            final long skip = fin.skip(3L);
            System.out.println(skip);
            final byte[] bytes = new byte[100];
            //从1开始读取4个字符，放入字符数组指定下标处
            final int read = fin.read(bytes, 1, 4);
            System.out.println(read);
            for (byte aByte : bytes) {
                System.out.println(Character.valueOf((char) aByte));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void outputStreamTest1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/test.txt";
        try (final FileOutputStream fop = new FileOutputStream(filePath, true)) {
            fop.write("可爱".getBytes());
            fop.write("abc".getBytes());
            //刷新流，将此之前的所有数据给操作系统，让操作系统写入硬件设备
            fop.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void byteArrayInputStreamTest1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/test.txt";
        try (final FileOutputStream fop = new FileOutputStream(filePath, true);
             final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("abcd".getBytes(StandardCharsets.UTF_8))) {
            System.out.println((char) byteArrayInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void byteArrayOutputStreamTest1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/test.txt";
        try (final FileOutputStream fop = new FileOutputStream(filePath, true);
             final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024)) {
            //写入到字节数组
            byteArrayOutputStream.write("可可爱爱".getBytes());
            //一次性写入到，另一个输出流
            byteArrayOutputStream.writeTo(fop);
            //刷新流，将此之前的所有数据给操作系统，让操作系统写入硬件设备
            fop.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void objectInputStreamTest1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/objectTest.txt";
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {

            final Person o = (Person) objectInputStream.readObject();

            System.out.println(o);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void objectOutputStreamTest1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/objectTest.txt";
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath, false))) {
            //写入到字节数组
            objectOutputStream.write("1".getBytes());
            //刷新流，将此之前的所有数据给操作系统，让操作系统写入硬件设备
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void objectOutputStreamTest2() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile/objectTest.txt";
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath, false))) {

            final Person person = new Person();
            person.setStr1("str1")
                    .setStr2("str2")
                    .setAge(1)
                    .setBirthday(Calendar.getInstance().getTime());
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

@Data
@Accessors(chain = true)
class Person   implements Serializable {

    private static final long serialVersionUID = -8861126921891657698L;

    String str1;

    transient String str2;

    final String str3 = "123";

    static String str4;

    int age;

    Date birthday;

}