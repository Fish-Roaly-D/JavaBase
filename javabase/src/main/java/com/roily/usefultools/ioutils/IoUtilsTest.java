package com.roily.usefultools.ioutils;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @className：IOUtilsTest
 * @author: rolyfish
 * @description: apache.commons.io
 * @dte: 2022/6/23 00:09
 */
public class IoUtilsTest {

    private static String rootPath = "/Users/rolyfish/Desktop/MyFoot/testfile";

    /**
     * 将某一文件以字符串的形式读出
     *
     * @throws IOException
     */
    @Test
    public void readToString() throws IOException {
        String fileName = "test.txt";
        FileReader fileReader = new FileReader(new File(rootPath, fileName));
        String s = IOUtils.toString(fileReader);
        System.out.println(s);
        //关闭资源
        IOUtils.close(fileReader);
    }

    /**
     * 将字符串写入文件，一次性写完
     */
    @Test
    public void writeToFile() throws IOException {

        String fileName = "testwrite.txt";
        String str = "写入文件";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(rootPath, fileName), true);
        //以追加的形式写入文件
        IOUtils.write(str, fileOutputStream, StandardCharsets.UTF_8);
        IOUtils.close(fileOutputStream);
    }

    /**
     * 将字符串写入文件，一次性写完
     * 待解决为啥fileWriter不行
     */
    @Test
    public void writeToFile2() throws IOException {
        String fileName = "testwrite2.txt";
        String str = "dasdasd撒大大叔";
        //以追加的形式写入文件
        FileWriter fileWriter = new FileWriter(new File(rootPath, fileName), true);
        IOUtils.write(str, fileWriter);
        IOUtils.close(fileWriter);
    }

    /**
     * 复制文件
     */
    @Test
    public void fileCopy() throws IOException {
        //源文件
        String sourceFile = "test.txt";
        //目标文件
        String targetFile = "target.txt";
        FileReader fileReader = new FileReader(new File(rootPath, sourceFile));
        FileWriter fileWriter = new FileWriter(new File(rootPath, targetFile), true);

        final int copy = IOUtils.copy(fileReader, fileWriter);
        System.out.println(copy);
        IOUtils.close(fileReader, fileWriter);
    }
}
