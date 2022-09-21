package com.roily.equalsanddengdengyu;

import org.junit.Test;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/20
 */
public class EqualsAnd {

    /**
     * ==和equals
     */

    @Test
    public void ddy() {
        /**
         * 等等于比较的是字面量
         * 对于基本数据类型：比较的是‘数值’是否相等
         * 对于引用数据类型：比较的是‘内存地址’是否相等
         */
        int a = 1;
        int b = 1;
        System.out.println(a == b);

        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
    }

    @Test
    public void testEquals() {

        /**
         * equals()方法是Object类下的。Object类为所有类的父类或间接父类
         * 所以所有类都可以重写equals方法
         * String类重写了equals方法，比较俩对象的值（字符数组），而不是内存地址（不是同一个对象）
         */
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.equals(str2));

    }

    /**
     *
     * 对于基本数据类型的包装类型，强制使用equals判定对象是否相等
     *
     * 重写equals方法一定重写hashCode方法
     *
     * 基本数据类型只能==判定是否相等
     */
}
