package com.roily.booknode.javatogod._01faceobj.aboutthrowable;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Date: 2022/08/08/10:59
 * @Description:
 */
public class MyExceptionTest {

    @Test
    public void test1() {
        try {
            String str = null;
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        } catch (NullPointerException npe) {
            throw new MyException(npe, "5000", "空指针异常");
        }
    }


    @Test
    public void test2() {
        BufferedReader bi = null;
        try {
            bi = new BufferedReader(new FileReader("filename"));
            String line;
            while ((line = bi.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            //dosomething
        } finally {
            try {
                IOUtils.close(bi);
            } catch (IOException e) {
                //dosomething
            }
        }
    }

    @Test
    public void test3() {
        BufferedReader bi = null;
        try {
            bi = new BufferedReader(new FileReader("filename"));
            String line;
            while ((line = bi.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            //dosomething
        }
    }
    @Test
    public void test4() {
        try( BufferedReader bi = new BufferedReader(new FileReader("filename"))) {

            String line;
            while ((line = bi.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            //dosomething
        }
    }
}
