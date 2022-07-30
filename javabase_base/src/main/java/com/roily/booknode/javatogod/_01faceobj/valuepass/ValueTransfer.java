package com.roily.booknode.javatogod._01faceobj.valuepass;

import org.junit.Test;

/**
 * @classname：ValueTransfer
 * @author: rolyfish
 * @description: Java的值传递
 * @date: 2022/7/30 12:39
 */
public class ValueTransfer {

    /**
     * 基本数据类型，只有值的概念
     *
     * @param i
     */
    void simpType(int i) {
        i = 999;
    }

    void referenceType1(StringBuilder sb) {
        sb.append("追加");
    }

    void referenceType2(StringBuilder sb) {
        sb = new StringBuilder();
        sb.append("追加");
    }


    @Test
    public void test1() {
        System.out.println("基本数据类型");
        int i = 1;
        System.out.println("原值：" + i);
        simpType(i);
        System.out.println("修改后：" + i);

        System.out.println("引用数据类型，未修改引用");
        final StringBuilder sb1 = new StringBuilder("123");
        System.out.println("原值：" + sb1.toString());
        referenceType1(sb1);
        System.out.println("修改后：" + sb1.toString());

        System.out.println("引用数据类型，修改引用");
        final StringBuilder sb2= new StringBuilder("123");
        System.out.println("原值：" + sb2.toString());
        referenceType2(sb2);
        System.out.println("修改后：" + sb2.toString());
    }

}
