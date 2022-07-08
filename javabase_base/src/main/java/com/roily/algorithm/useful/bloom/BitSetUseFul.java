package com.roily.algorithm.useful.bloom;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

import java.util.BitSet;

/**
 * @classname：BitSetUseFul
 * @author: rolyfish
 * @description: bitset去重
 * @date: 2022/7/9 01:19
 */
public class BitSetUseFul {


    /**
     * 去重
     *
     * @param source
     */
    public static int[] withoutRepeat(int[] source) {
        final BitSet bitSet = new BitSet();
        for (Integer element : source) {
            bitSet.set(element);
        }
        final int[] target = bitSet.stream().toArray();

        System.arraycopy(target, 0, source, 0, target.length);

        return target;
    }


    public static void main(String[] args) {

        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 20);

        System.out.println("原数组" + CollectionUtils.arrayToList(randomColl));
        final int[] target = withoutRepeat(randomColl);

        System.out.println("去重" + CollectionUtils.arrayToList(target));
    }


}
