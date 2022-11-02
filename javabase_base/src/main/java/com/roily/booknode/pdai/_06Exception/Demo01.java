package com.roily.booknode.pdai._06Exception;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Date: 2022/11/02/10:12
 * @Description: 受检异常  &  非受检异常
 */
public class Demo01 {


    /**
     * 抛出非受检异常
     *
     * @throws RuntimeException
     */
    static void m1() throws RuntimeException {
    }

    /**
     * 调用可能会抛出非受检异常，无需强制显示处理异常
     */
    static void m2() {
        m1();
    }

    /**
     * 抛出受检异常
     *
     * @throws IOException
     */
    static void m3() throws IOException {
    }

    /**
     * 调用可能会抛出受检异常，必须强制显示处理异常
     */
    static void m4() throws IOException {
        m3();
    }


    /**
     * try catch 捕获非受检异常，无需在方法前使用throws关键字
     */
    static void m5() {
        try {

        } catch (RuntimeException e) {
            throw e;
        }
    }

    /**
     * 调用可能会抛出非受检异常的方法，不必须显示处理
     */
    static void m6() {
        m5();
    }

    /**
     * try catch 捕获受检异常，如果不选择转化受检异常为非受检异常直接抛出，则必需在方法前使用throws关键字声明受检异常
     *
     * @throws IOException
     */
    static void m7() throws IOException {
        try {
            IOUtils.readLines(new FileReader(""));
            System.out.println();
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 调用可能会抛出受检异常的方法，需要显示catch() 或 在方法前throws
     */
    static void m8() {
        try {
            m7();
        } catch (IOException e) {
        }
    }


    /**
     * try catch 捕获受检异常，将受检异常转化为非受检异常抛出
     *
     * @throws IOException
     */
    static void m9() {
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void m10() {
        m9();
    }


    public static void main(String[] args) {
        m8();
    }

}
