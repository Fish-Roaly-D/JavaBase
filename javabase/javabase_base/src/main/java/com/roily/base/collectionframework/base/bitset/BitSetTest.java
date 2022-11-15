package com.roily.base.collectionframework.base.bitset;

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
     * BitSet底层使用long数组存储数据？
     * - 相比于<KEY-value>是一种存储效率较高的数据结构
     * - 同样的相较于<key-value>存储的数据有限，只能表示0和1
     * - 常用于大数据量的查重，去重
     *
     * - hash的原理就是将一个大数据量映射到一个小数据量上，obj->int。并且存储效率只有50左右，所以数据量大了map不合适
     * - bitSet称为位图，每一位代表一个状态，如果说数据量较大且较为集中，bitSet优势很大
     *
     */

    /**
     * 测试nextSetBit
     * - 获取下一个不为0的int值
     */
    @Test
    public void testNextSetBit() {
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
        System.out.println(bitSet.nextSetBit(10));
        System.out.println(bitSet.nextSetBit(11));
        System.out.println(bitSet.nextSetBit(65));
    }

    /**
     * 测试nextClearBit
     */
    @Test
    public void testNextClearBit() {
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
     * <p>
     * 返回long的二进制表示法 为1的个数
     */
    @Test
    public void testBitCount() {

        System.out.println(Long.bitCount(10L));
        System.out.println(Long.bitCount(7L));
        System.out.println(Long.bitCount(5L));
        System.out.println(Long.bitCount(4L));
    }
}
