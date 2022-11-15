package com.roily.booknode.pdai.thedatastructure.sort.InsertionSort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

/**
 * @classname：StraightInsertionSort
 * @author: rolyfish
 * @description: 直接插入排序
 * @date: 2022/11/7 22:14
 */
public class StraightInsertionSort<T extends Comparable> {

    public static <T extends Comparable> void straightInsertionSort(T[] array) {
        straightInsertionSort(array, 0, array.length - 1, true);
    }

    public static <T extends Comparable> void straightInsertionSort(T[] array, int last) {
        straightInsertionSort(array, 0, last, true);
    }


    public static <T extends Comparable> void straightInsertionSort(T[] array, int first, int last) {
        straightInsertionSort(array, first, last, true);
    }

    /**
     * @param array 待排序集合
     * @param first 排序起始下标
     * @param last  排序终止下标
     * @param flag  从0开始 true  从1开始 false
     */
    public static <T extends Comparable> void straightInsertionSort(T[] array, int first, int last, boolean flag) {
        last = Math.min(array.length, last);
        if (!flag) {
            first--;
            last--;
        }
        for (int i = first + 1; i <= last; i++) {
            //[first i-1]是有序的，给i在[first i-1]找个合适位置插入
            //遍历 i-1 到 first
            int j = i - 1;
            for (; j >= first; j--) {
                //待插入元素比，array[j]大于等于，插入位置确定了 j+1
                if (array[i].compareTo(array[j]) >= 0) {
                    break;
                }
            }
            //不相等才全体后移，相等插入位置即是当前位置，i++
            if (j != i - 1) {
                //缓存被覆盖的值，也是待插入元素
                T temp = array[i];
                int k = i - 1;
                //j+1 到 i-1 全体后移
                for (; k > j; k--) {
                    array[k + 1] = array[k];
                }
                //将值放入合适位置
                array[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        final Integer[] randomColl = SortUtils.createRandomColl(10, 5, 15);
        SortUtils.print(randomColl);
        straightInsertionSort(randomColl);
        SortUtils.print(randomColl);
    }
}

