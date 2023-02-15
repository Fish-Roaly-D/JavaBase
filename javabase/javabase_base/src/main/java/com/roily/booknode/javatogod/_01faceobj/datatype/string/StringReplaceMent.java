package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.junit.Test;

import java.util.regex.Matcher;

/**
 * @Date: 2023/02/13/14:43
 * @Description:
 */
public class StringReplaceMent {


    @Test
    public void TestReplacement(){

        String str = "123abc12";
        final String replace = str.replace("1", "$");
        System.out.println(replace);


        final String replaceAll = str.replaceAll("[0-9]{2,}+", "xxxx");

        System.out.println(replaceAll);


        System.out.println(str.replaceFirst("[0-9]{3,}+", "xxxx"));

        System.out.println(str.matches("[0-9]{3,}+"));


    }
}
