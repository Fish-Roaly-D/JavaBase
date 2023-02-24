package com.roily.booknode.javatogod._13jvm;

/**
 * @Date: 2023/02/22/13:48
 * @Description:
 */
public class Person {

    private String name;
    // 此字段在当前类中没有使用，不会生成对应Fieldref结构体。但会存储字段名称
    private Integer age;
    // 作为引用类型 Ljava/lang/Integer
    private static Integer num1 = 10;
    // 基本数据类型，对应类型为 I
    private static int num2 = 10;

    private final int num3 = 100;

    private int num4 = 32768;

    private long num5 = 1L;
    private Long num6 = 2L;
    private double num7 = 1D;
    private Double num8 = 2D;

    private String str = "yuyc";


    public String getName() {
        return name;
    }

    public static void main(String[] args) {

    }

}
