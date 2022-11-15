package com.roily.booknode.javatogod._01faceobj.aboutthrowable;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Date: 2022/08/08/10:32
 * @Description: 受检异常
 */
public class CheckedException {


    public void test1() throws IOException {
        IOUtils.readLines(new FileInputStream("filename"),  StandardCharsets.UTF_8);
    }

    public void test2()   {
        try {
            IOUtils.readLines(new FileInputStream("filename"),  StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
