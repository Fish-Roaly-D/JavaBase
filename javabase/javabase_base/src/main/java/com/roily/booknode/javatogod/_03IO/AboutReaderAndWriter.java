package com.roily.booknode.javatogod._03IO;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import sun.security.action.GetPropertyAction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;

/**
 * @classname：AboutReaderAndWriter
 * @author: rolyfish
 * @description: 字符输入输出流
 * @date: 2022/8/24 22:05
 */
public class AboutReaderAndWriter {

    @Test
    public void testReader() {
        final String s = AccessController.doPrivileged(
                new GetPropertyAction("file.encoding"));




        System.out.println(s);
    }


    @Test
    public void testFileInputStream1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";

        try (final InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(filePath, "dataStreamFile.txt")), StandardCharsets.UTF_8)) {
            final char[] buffer = new char[1024];
            int len = 0;
            while ((len = inputStreamReader.read(buffer)) > 0) {
                System.out.println(String.valueOf(buffer, 0, len));
            }
        } catch (IOException e) {

        }
    }

    @Test
    public void testFileOutputStream1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        try (final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(filePath, "dataStreamFile.txt")), "GBK")) {
            outputStreamWriter.write("hhhhhhhhhhhh哈哈哈哈");
            outputStreamWriter.flush();
        } catch (IOException e) {
        }
    }

    @Test
    public void testFileReader1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        try (final FileReader fileReader = new FileReader(new File(filePath, "dataStreamFile.txt"))) {
            final char[] buffer = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buffer)) > 0) {
                System.out.println(String.valueOf(buffer, 0, len));
            }
        } catch (IOException e) {
        }
    }

    @Test
    public void testFileWriter1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        try (final FileWriter fileWriter = new FileWriter(new File(filePath, "dataStreamFile.txt"))) {
            fileWriter.write("12331");
            //追加写入，返回this，类似于StringBuilder 的append
            fileWriter.append("xxxxxx").append("追加");
            //将流刷入操作系统，让操作系统去写入硬件，最终结果是否写入成功由操作系统决定
            //如果不刷新，流也不关闭，数据不会写入硬件
            fileWriter.flush();
        } catch (IOException e) {

        }
    }

    @Test
    public void testBufferedWriter1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath, "dataStreamFile.txt")), StandardCharsets.UTF_8))) {
            bufferedWriter.write("a可可爱爱");
            bufferedWriter.write("快快乐乐");
            bufferedWriter.write('a');
            bufferedWriter.write(96);
            bufferedWriter.write(new char[]{'x', 'x'});
            bufferedWriter.write("\n");
            bufferedWriter.write("\t");
            //新起一行
            bufferedWriter.newLine();
            bufferedWriter.write("开开心心");
        } catch (IOException e) {

        }
    }

    @Test
    public void testBufferedReader1() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath, "dataStreamFile.txt")), StandardCharsets.UTF_8))) {
            final char[] chars = new char[1];
            final int read = bufferedReader.read();
            System.out.println(new String(chars, 0, 1));
            String buffer = "";
            while ((buffer = bufferedReader.readLine()) != null) {
                System.out.println(buffer);
            }
            //一次性读出来
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath, "dataStreamFile.txt")), StandardCharsets.UTF_8));
            bufferedReader1.lines().forEach(System.out::println);
        } catch (IOException e) {

        }
    }


    @Test
    public void testFlush() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/myfoot/foot/testfile";
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fo = null;
        try {
            outputStreamWriter = new OutputStreamWriter(fo = new FileOutputStream(new File(filePath, "dataStreamFile.txt")));
            //如此写入不了，没有flush 也没有 关闭流
            outputStreamWriter.write("你好呀xxxxx");
            outputStreamWriter.flush();
        } catch (IOException e) {
            try {
                IOUtils.close(outputStreamWriter,fo);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
