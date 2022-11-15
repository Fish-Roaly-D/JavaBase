package com.roily.algorithm.useful.bloom;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @classname：HashUseFul
 * @author: rolyfish
 * @description: 哈希map去重
 * @date: 2022/7/9 00:39
 */
public class HashUseFul {

    /**
     * 对数组去重
     *
     * @param source
     */
    public static void withoutRepeat(int[] source) {
        final int[] temp = new int[source.length];
        final Map<Integer, Boolean> map = new HashMap<>();
        int index = 0;
        for (int element : source) {
            if (!map.containsKey(element)) {
                map.put(element, true);
                temp[index++] = element;
            }
        }
        System.arraycopy(temp, 0, source, 0, temp.length);
    }

    public static void main(String[] args) {
        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 20);
        System.out.println(CollectionUtils.arrayToList(randomColl));
        withoutRepeat(randomColl);
        System.out.println(CollectionUtils.arrayToList(randomColl));
    }

}
