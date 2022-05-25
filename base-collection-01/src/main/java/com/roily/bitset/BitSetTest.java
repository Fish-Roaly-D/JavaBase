package com.roily.bitset;

import org.junit.Test;

import java.util.BitSet;

/**
 * @version 1.0.0
 * @Description
 * @ClassName BitSetTest.java
 * @author: RoilyFish
 * @date: 2022/5/25 1:01
 */
public class BitSetTest {


    /**
     * 测试nextSetBit
     */
    @Test
    public void testNextSetBit(){

        BitSet bitSet = new BitSet();

        bitSet.set(10);
        bitSet.set(5);


        System.out.println("//0 -4  下一个为5");
        System.out.println(bitSet.nextSetBit(0));
        System.out.println(bitSet.nextSetBit(1));
        System.out.println(bitSet.nextSetBit(2));
        System.out.println(bitSet.nextSetBit(3));
        System.out.println(bitSet.nextSetBit(4));
        System.out.println(bitSet.nextSetBit(5));


        System.out.println("//6 -9  下一个为10");
        System.out.println(bitSet.nextSetBit(6));
        System.out.println(bitSet.nextSetBit(7));
        System.out.println(bitSet.nextSetBit(8));
        System.out.println(bitSet.nextSetBit(9));


    }

    /**
     * 测试nextClearBit
     */
    @Test
    public void testNextClearBit(){
        BitSet bitSet = new BitSet();
        bitSet.set(10);
        bitSet.set(5);
        bitSet.set(6);
        bitSet.set(7);
        bitSet.set(8);
        System.out.println("5下一个为0   的是9");
        System.out.println(bitSet.nextClearBit(0));
        System.out.println(bitSet.nextClearBit(5));
    }

    /**
     * 测试Long的bitCount()
     *
     * 返回long的二进制表示法 为1的个数
     */
    @Test
    public void testBitCount(){

        System.out.println(Long.bitCount(10L));
        System.out.println(Long.bitCount(7L));
        System.out.println(Long.bitCount(5L));
        System.out.println(Long.bitCount(4L));
    }
}
