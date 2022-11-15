package com.roily.base.collectionframework.base.bitset;

import org.junit.Test;

import java.util.BitSet;

/**
 * @version 1.0.0
 * @Description 移位运算测试
 * @ClassName BitOperationTest.java
 * @author: RoilyFish
 * @date: 2022/5/24 12:51
 */
public class BitOperationTest {

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
     * 上面的例子完全可以这样写
     * - 一个n位的数据  右(左)移 n+k位，相当于右(左)移k位，即 (n+K)%取余，也就是(n+k)和 (n - 1)按位与。
     */
    @Test
    public void test(){
        int intX = 32;
        int longX = 64;
        System.out.println(1L>>1);
        System.out.println((1L >> 64)+"等价于"+ (1L >> (64 & (longX-1))));
        System.out.println((1L >> 65)+"等价于"+ (1L >> (65 & (longX-1))));
        System.out.println((1L >> 66)+"等价于"+ (1L >> (66 & (longX-1))));

        System.out.println((112333333333333L >> 140)+"等价于"+ (112333333333333L >> (140 & (longX-1))));


    }

    /**
     * 测试移负数位
     */
    @Test
    public void testShift(){
        System.out.println(0xffffffffffffffffL);
        //无符号移位，不论正负 符号位补0
        System.out.println(0xffffffffffffffffL >>> 1);
        //互补等同
        System.out.println(0xffffffffffffffffL >>> -2);
        System.out.println(0xffffffffffffffffL >>> 62);
        System.out.println(0xffffffffffffffffL >>> 48);

        System.out.println(0xffffffffffffffffL << 1);
        System.out.println(0xffffffffffffffffL << 65);

        System.out.println(0xffffffffffffffffL << 64);

    }

    /**
     * 负数取余
     */
    @Test
    public void testQuyu(){
        System.out.println(-2L % 64);
        System.out.println(-(2L & 63));
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

    /**
     * 测试break在if中执行
     * 跳出for循环
     */
    @Test
    public void testBreak(){
        for (int i = 0; i < 10; i++) {
            if (i == 5 ){
                break;
            }
            System.out.println(i);
        }
    }

    @Test
    public void testAddAndGet() {

        BitSet bitSet = new BitSet();
        //bitSet.set(0);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.get(0));
    }

}
