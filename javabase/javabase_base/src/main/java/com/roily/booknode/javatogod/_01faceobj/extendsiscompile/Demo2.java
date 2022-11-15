package com.roily.booknode.javatogod._01faceobj.extendsiscompile;

/**
 * @Date: 2022/07/29/16:56
 * @Description:
 * 类变量、成员变量、局部变量
 */
public class Demo2 {
    //类变量
    final static String str1 = "abc";
    static String str2 = "abc";

    //成员变量
    String str3 = "abc";

    //局部变量
    void method01(String str1) {
        String str2 = "abc";
        for (StringBuilder str = new StringBuilder("abc"); str.toString().equals("abc"); ) {
        }
    }
}
