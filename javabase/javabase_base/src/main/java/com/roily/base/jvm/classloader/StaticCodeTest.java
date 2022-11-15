package com.roily.base.jvm.classloader;

/**
 * @classname：StaticCodeTest
 * @author: rolyfish
 * @description: 静态代码块存在顺序问题
 * @date: 2022/7/25 23:46
 */
public class StaticCodeTest {
    private static StaticCodeTest staticCodeTest = new StaticCodeTest();
    private static int a;
    private static int b = 0;
    //
    //static {
    //    a = 10;
    //    b = 9;
    //}

    public StaticCodeTest() {
        a++;
        b++;
    }

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
    }
}
