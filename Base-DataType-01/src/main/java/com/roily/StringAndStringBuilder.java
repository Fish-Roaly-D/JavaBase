package com.roily;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class StringAndStringBuilder {


    public static void main(String[] args) {
        String str = "abc";
        changeStr(str);
        System.out.println(str);
        System.out.println("===============");

        StringBuilder strBuilder = new StringBuilder("abc");
        changeStrBuilder(strBuilder);
        System.out.println(strBuilder);
        System.out.println("===============");
    }


    public static void changeStr(String str) {

        str += "123";

    }

    public static void changeStrBuilder(StringBuilder str) {

        str.append("123");

    }


}
