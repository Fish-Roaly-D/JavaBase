package com.roily.algorithm.sort.exchangesort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

/**
 * @classname：QuickSort
 * @author: rolyfish
 * @description: 快速排序
 * @date: 2022/7/5 23:24
 */
public class QuickSort {

    public static void quick(int[] source) {
        quickSort(source, 0, source.length - 1);
    }

    /**
     * 快速排序
     *
     * @param source 无序集合
     * @param prev   开始下标
     * @param last   结束下标
     */
    public static void quickSort(int[] source, int prev, int last) {
        //递归，需要结束标志，无此标志形成死循环
        if (prev < last) {
            final int middle = getMiddle(source, prev, last);
            quickSort(source, middle + 1, last);
            quickSort(source, prev, middle - 1);
        }
    }


    public static int getMiddle(int[] source, int prev, int last) {
        //以首个元素为基准
        final int middleElement = source[prev];

        while (prev < last) {
            //找到右边比基准小的元素
            while (prev < last & middleElement <= source[last]) {
                last--;
            }
            source[prev] = source[last];

            //找到左边比基准大的元素
            while (prev < last & middleElement >= source[prev]) {
                prev++;
            }
            source[last] = source[prev];
        }

        source[prev] = middleElement;
        return prev;
    }

    public static void main(String[] args) {
        final int[] randomColl = DirectInsertSort.createRandomColl(30, 10, 100);
        System.out.println("源集合：=》" + CollectionUtils.arrayToList(randomColl));
        quick(randomColl);
        System.out.println("快排后：=》" + CollectionUtils.arrayToList(randomColl));
    }
}
