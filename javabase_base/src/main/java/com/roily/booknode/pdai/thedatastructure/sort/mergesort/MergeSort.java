package com.roily.booknode.pdai.thedatastructure.sort.mergesort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

import java.lang.reflect.Array;

/**
 * @classname：MergeSort
 * @author: rolyfish
 * @description: 归并排序
 * @date: 2022/11/10 01:23
 */
public class MergeSort {

    /**
     * 自上而下的归并排序
     * - 一拆为二，对这两个序列进行归并排序
     * - 合并
     * 递归
     *
     * @param array
     * @param start
     * @param end
     * @param <T>
     */
    public static <T extends Comparable> void mergeSort(T[] array, int start, int end) {
        if (start < end) {
            //递归退出条件  start >= end 也就是待排序序列长度小于1了
            int mid = (start + end) / 2;
            //左边递归归并
            mergeSort(array, start, mid);
            //右边递归归并
            mergeSort(array, mid + 1, end);
            //对两个有序序列进行合并。 为啥是有序的？拆分到最后，序列个数都为1，一层一层合并都是有序的，这个算法是归并算法的核心
            merge(array, start, mid, end);
        }
    }

    public static <T extends Comparable> void merge(T[] array, int start, int mid, int end) {
        //需要一个缓存空间，存放两个有序序列合并后的结果
        T[] tempA = (T[]) Array.newInstance(Comparable.class, end - start + 1);
        int ls = start;
        int rs = mid + 1;
        int i = 0;
        /**
         * 逐个比较，小的放入缓存数组，直到一方为空
         */
        while (ls <= mid && rs <= end) {
            if (array[ls].compareTo(array[rs]) <= 0) {
                tempA[i++] = array[ls++];
            } else {
                tempA[i++] = array[rs++];
            }
        }

        //剩余的都是有序的且较大的直接放入缓存数组
        while (ls <= mid) {
            tempA[i++] = array[ls++];
        }
        while (rs <= end) {
            tempA[i++] = array[rs++];
        }

        //将缓存拷贝进原数组
        for (int j = 0; j < i; j++) {
            array[start + j] = tempA[j];
        }
        tempA = null;
    }

    public static void main(String[] args) {

        final Integer[] randomColl = SortUtils.createRandomColl(20, 0, 100);
        SortUtils.print(randomColl);
        mergeSort(randomColl, 0, randomColl.length - 1);
        SortUtils.print(randomColl);

    }

}
