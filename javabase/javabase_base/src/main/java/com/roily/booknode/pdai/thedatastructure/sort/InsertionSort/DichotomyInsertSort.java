package com.roily.booknode.pdai.thedatastructure.sort.InsertionSort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

/**
 * @classname：DichotomyInsertSort
 * @author: rolyfish
 * @description: 二分发插入排序
 * @date: 2022/11/8 00:14
 */
public class DichotomyInsertSort {

    /**
     * 核心思想
     * - 将待排序序列分为，有序和无序两部分
     * - 对有序序列进行标三个点 left、mid、right
     * - 无序序列每次取出首个元素，和mid进行比较
     * --- 大于等于，left = mid+1 mid = (left + right)/2
     * --- 小于 right = mid-1  mid = (left+mid)/2
     * --- 循环条件为 left <= right
     * --- 结束循环 left及其右边元素右移， 待插入元素插入 left所在下标位置
     */
    public static <T extends Comparable> void dichotomyInsertSort(T[] array, int first, int last, boolean flag) {
        if (!flag) {
            first--;
            last--;
        }
        int left = 0;
        int right = 0;
        int mid = 0;
        //待排序元素
        int tempIndex = first + 1;
        for (; tempIndex <= last; tempIndex++) {
            left = first;
            right = tempIndex - 1;
            T temp = array[tempIndex];
            while (left <= right) {
                mid = (right + left) / 2;
                if (array[tempIndex].compareTo(array[mid]) >= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left != tempIndex) {
                int m = tempIndex;
                for (; m > left; ) {
                    array[m] = array[--m];
                }
                array[left] = temp;
            }
        }
    }


    public static void main(String[] args) {

        final Integer[] randomColl = SortUtils.createRandomColl(20, 5, 100);
        SortUtils.print(randomColl);
        dichotomyInsertSort(randomColl, 0, randomColl.length - 1, true);
        SortUtils.print(randomColl);

    }

}
