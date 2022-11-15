package com.roily.algorithm.sort.merge;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

/**
 * @classname：MergeSort
 * @author: rolyfish
 * @description: 归并排序
 * @date: 2022/7/6 00:55
 */
public class MergeSort {
    public static void split(int[] source, int prev, int last) {

        //这是一个归并，得有结束归并的条件
        if (prev < last) {

            int mid = (prev + last) / 2;
            //左边
            split(source, prev, mid);
            //右边
            split(source, mid + 1, last);
            //合并
            merge(source, prev, mid, last);
        }
    }

    private static void merge(int[] source, int prev, int mid, int last) {
        //协助数组长度
        final int tempLength = last - prev + 1;
        //协助数组
        final int[] temp = new int[tempLength];
        //左右两边起始下标
        int i = prev;
        int j = mid + 1;
        //协助数组起始下标
        int k = 0;

        while (i <= mid & j <= last) {
            //i 较小， i后移，且对应元素记录协助数组
            if (source[i] < source[j]) {
                temp[k++] = source[i++];
            } else {
                temp[k++] = source[j++];
            }
        }

        //将左边剩余元素记录进协助数组
        while (i <= mid) {
            temp[k++] = source[i++];
        }
        //将左边剩余元素记录进协助数组
        while (j <= last) {
            temp[k++] = source[j++];
        }

        //跟新原数组
        for (int index = 0; index < tempLength; index++) {
            source[prev++] = temp[index];
        }
    }

    public static void main(String[] args) {

        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 100);
        System.out.println("原数组：=》" + CollectionUtils.arrayToList(randomColl));
        split(randomColl, 0, randomColl.length - 1);

        System.out.println("归并排序后=》" + CollectionUtils.arrayToList(randomColl));

    }
}
