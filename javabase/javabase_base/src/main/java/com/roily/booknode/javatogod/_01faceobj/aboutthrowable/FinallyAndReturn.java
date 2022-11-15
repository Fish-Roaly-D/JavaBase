package com.roily.booknode.javatogod._01faceobj.aboutthrowable;

import org.junit.Test;

/**
 * @Date: 2022/08/08/12:56
 * @Description:
 */
public class FinallyAndReturn {


    public StringBuilder method1(Boolean flag) {
        StringBuilder sb = new StringBuilder();
        if (flag) {
            sb.append("方法在try代码块之前return\n");
            return sb;
        }
        try {

        } catch (Exception e) {
            System.out.println("进入try代码块\n");
        } finally {
            System.out.println("finally代码块执行\n");
        }
        return sb;
    }

    public StringBuilder method2(Boolean flag) {
        StringBuilder sb = new StringBuilder();
        if (flag) {
            System.exit(0);
        }
        try {

        } catch (Exception e) {
            System.out.println("进入try代码块\n");
        } finally {
            System.out.println("finally代码块执行\n");
        }
        return sb;
    }

    @Test
    public void test1() {

        method1(true);
        method2(true);
    }


    public int method3() {
        int i = 0;
        try {
            return i;
        } finally {
            System.out.println("finally代码块执行");
            i += 1;
        }
    }

    public String method4() {
        String str = "123";
        try {
            return str;
        } finally {
            System.out.println("finally代码块执行");
            str += "abc";
        }
    }

    @Test
    public void test2() {
        int i = method3();
        System.out.println("method3返回结果：" + i);

        String str = method4();
        System.out.println("method4返回结果：" + str);
    }


    public StringBuilder method5() {
        StringBuilder sb = new StringBuilder("");
        try {
            return sb.append("123");
        } finally {
            System.out.println("finally代码块执行");
            sb.append("abc");
        }
    }

    @Test
    public void test3() {
        StringBuilder sb = method5();
        System.out.println("method5返回结果：" + sb.toString());
    }

}
