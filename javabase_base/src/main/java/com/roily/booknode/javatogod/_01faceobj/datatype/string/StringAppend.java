package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.junit.Test;

/**
 * @classname：StringAppend
 * @author: rolyfish
 * @description: 字符串拼接原理
 * @date: 2022/8/1 00:58
 */
public class StringAppend {

    @Test
    public void test1() {
        String str1 = "abc" + "123";
        System.out.println(str1);
    }

    void method(String str1, String str2) {
        final String strX = str1 + "," + str2;
    }

}
