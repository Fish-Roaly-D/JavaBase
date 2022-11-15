package com.roily.base.jvm.day03;

/**
 * @classname：CpInfoIntAndFloat
 * @author: rolyfish
 * @description: int 和 float 常量池
 * @date: 2022/8/7 13:45
 */
public class CpInfoStringAndUtf8 {

    String str1 = "abc";
    String str2 = "abc1";

    public void test() {
        String str = "abc";
        System.out.println(str == str1);
    }
}