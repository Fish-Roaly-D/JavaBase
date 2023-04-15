package com.roily.base.datatype.integer;

import org.junit.Test;

/**
 * descripte:
 * @author: RoilyFish
 * @date: 2022/2/20
 */
public class IntegerLearn {
    /**
     * int知识点：装箱拆箱、缓存池技术
     */

    //自动装箱  拆箱
    @Test
    public void test01(){
        //自动装箱 =》 Integer.valueOf(10)
        Integer i1 = 10;
        //自动拆箱  Integer.intValue(i1)
        int i2 = i1;
    }

    //byte short int long缓存技术
    @Test
    public void test02(){

        System.out.println("===========Byte============");
        byte b1 = 'a';
        byte b2 = 'a';
        System.out.println(b1 == b2);
        Byte B1 = 'a';
        Byte B2 = 'a';
        System.out.println(B1 == B2);

        System.out.println("===========Short============");
        short s1 = 10;
        short s2 = 10;
        System.out.println(s1 == s2);
        Short S1 = 1000;
        Short S2 = 1000;
        System.out.println(S1 == S2);
        Short S3 = 127;
        Short S4 = 127;
        System.out.println(S3 == S4);

        System.out.println("===========Int============");
        int i1 = 10;
        int i2 = 10;
        System.out.println(i1 == i2);
        Integer I1 = 1000;
        Integer I2 = 1000;
        System.out.println(I1 == I2);
        Integer I3 = 127;
        Integer I4 = 127;
        System.out.println(I3 == I4);

        System.out.println("===========Long============");
        long l1 = 10;
        long l2 = 10;
        System.out.println(l1 == l2);
        Long L1 = 1000L;
        Long L2 = 1000L;
        System.out.println(L1 == L2);
        Long L3 = 127L;
        Long L4 = 127L;
        System.out.println(L3 == L4);

        /**
         * 基本数据类型的包装类型属于引用类型，引用类型的'=='比较的是内存地址
         *
         * byte short int long对应的包装类型都有缓存池技术 其范围为 [-128 127]
         *
         * char 为0-127
         *
         * 当超过这个范围不建议使用`==`判断其值是否相等，应使用equals
         */
    }

}
