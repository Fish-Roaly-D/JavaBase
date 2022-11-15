package com.roily.base.datatype.stringandsb;

/**
 * descriptive:
 * java中只有值传递。
 * 基本数据类型就是值、引用数据类型的值指的是所指向对象的内存地址
 * <p>
 * String不可变。
 * sb1、sb2调用append可变。一个线程安全、一个非线程安全。
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class StringAndStringBuilder {


    public static void main(String[] args) {
        String str = "abc";
        System.out.println("String.class==原字符串=>" + str);
        changeStr(str);
        System.out.println("String.class==修改后=>" + str);
        System.out.println("===============");

        StringBuilder strBuilder = new StringBuilder("abc");
        System.out.println("SB.class==原字符串=>" + strBuilder);
        changeStrBuilder(strBuilder);
        System.out.println("SB.class==修改后=>" + strBuilder);
        System.out.println("===============");

        StringBuffer sb = new StringBuffer("abc");
        System.out.println("SBx.class==原字符串=>" + sb);
        changeStrBuffer(sb);
        System.out.println("SBx.class==修改后=>" + sb);
        System.out.println("===============");
    }


    public static void changeStr(String str) {

        str += "123";

    }

    public static void changeStrBuilder(StringBuilder str) {

        str.append("123");

    }

    public static void changeStrBuffer(StringBuffer sb) {

        sb.append("123");

    }


}
