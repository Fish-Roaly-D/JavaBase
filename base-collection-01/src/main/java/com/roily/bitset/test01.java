package com.roily.bitset;

import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * @version 1.0.0
 * @Description
 * @ClassName test01.java
 * @author: RoilyFish
 * @date: 2022/5/24 12:51
 */
public class test01 {

    /**
     * 移位运算，int类型为32位，表示范围位 [-2^32,2^32]
     * int类型的1左移32位相当于没移动，左移33位相当于左移一位。也就是 移位位数和32取余。
     */
    @Test
    public void shift() throws InterruptedException {

        System.err.println("左移");
        //相当于没移动
        System.out.println(1L << 64);
        //相当于移动1位
        System.out.println(1L << 65);
        System.out.println(1L << 66);
        //结果是1L
        System.out.println(0L | (1L << 64));
        //结果是3L
        System.out.println(1L | (1L << 65));
        //结果是 7L
        System.out.println(3L | (1L << 66));
        //相当于没移动
        System.out.println("右移64=>"+(1L >> 64));
        //相当于移动1位
        System.out.println(1L >> 65);
        System.out.println(1L >> 66);

    }

    /**
     * ~  波浪号取反的意思：二进制按位取反（结果计算机存为补码，转化为机器码（原码））
     *
     * 表现为：取反减一
     */
    @Test
    public void ttt(){
        //1-取反   -2
        System.out.println(~0b1);
        //-10   原->补->反->取反
        System.out.println(~-10);
    }

    @Test
    public void testAddAndGet() {

        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.get(0));
    }

}
