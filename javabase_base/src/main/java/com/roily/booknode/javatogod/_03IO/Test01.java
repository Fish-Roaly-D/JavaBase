package com.roily.booknode.javatogod._03IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2022/08/22/11:22
 * @Description:
 */
public class Test01 {

    /**
     * 字节流
     * OutputStream InputStream子类
     */
    @Test
    public void test1() {

        final ArrayList<String> strings = new ArrayList<>(10);

        strings.add("1");

        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("D:\\File\\Desktop\\blogXX\\foot\\testfile\\1.txt"))) {
            oo.writeObject(strings);
        } catch (IOException e) {

        }
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("D:\\File\\Desktop\\blogXX\\foot\\testfile\\1.txt"))) {
            System.out.println((ArrayList) oi.readObject());
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }


    @Test
    public void test2() {
        String str = "123";
        try (Reader stringReader = new StringReader(str);) {
            int buf;
            while ((buf = stringReader.read()) != -1) {
                System.out.print((char) buf);
            }
        } catch (IOException e) {
            System.out.println();
        }
    }


    /**
     * 当文件夹不存在则创建一个文件夹
     * @param specialCode
     */
    public void test3(int specialCode) {

        String path = "D:\\File\\Desktop\\blogXX\\foot\\testfile";
        final Date time = Calendar.getInstance().getTime();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String format = simpleDateFormat.format(time);
        String filePath = String.join("\\", path, format);

        final File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        String specialSuffix = String.join("_", "aaa", String.valueOf(specialCode));
        String fileName = String.join("\\", filePath, specialSuffix) + ".txt";

        final File file1 = new File(fileName);
        try (final FileWriter fileWriter = new FileWriter(file1)) {
            fileWriter.write("xxxxxxxxxxxx");
            fileWriter.flush();
        } catch (IOException e) {

        }
    }

    @Test
    public void testx(){

        for (int i = 0; i < 10; i++) {
            test3(i);
        }

    }
}
