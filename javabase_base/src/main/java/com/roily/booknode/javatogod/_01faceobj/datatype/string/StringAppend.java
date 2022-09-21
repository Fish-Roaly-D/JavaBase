package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.apache.commons.lang3.StringUtils;
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

    @Test
    public void testAppendByUtil(){
        String[] value = {"hello", "你好", "hello"};
        String result = StringUtils.join(value, ",");
        System.out.println(result);
    }


    @Test
    public void testAppendByStr(){
        String join = String.join(",", "hello", "你好", "hello", "4");
        System.out.println(join);
    }


}
