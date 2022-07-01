package com.roily.algorithm.sort.insertsort;

import org.springframework.util.CollectionUtils;

/**
 * @classname：DichotomyInsertSort
 * @author: rolyfish
 * @description: 二分法插入排序
 * @date: 2022/7/1 01:21
 */
public class DichotomyInsertSort {


    public static void dichotomyInsertSort(int[] source) {

        for (int i = 0; i < source.length; i++) {
            //待排序元素
            int temp = source[i];
            //每次都从0开始比较
            int left = 0;
            //【0-(i-1)】元素是有序的
            int right = i - 1;
            //mid需要动态修改，这里给默认值
            int mid = 0;

            //left所在下标则为需要插入下标
            while (left <= right) {
                mid = right + left / 2;
                if (temp < source[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //将left及其之后元素后移
            for (int j = i - 1; j >= left; j--) {
                source[j + 1] = source[j];
            }
            //当i==left时说明，待排序元素大于已有序元素集合最大值，则无需排序
            if (i != left) {
                source[left] = temp;
            }
        }
    }


    public static void main(String[] args) {

        final int[] source = DirectInsertSort.createRandomColl(20, -10, 15);
        System.out.println("源集合：");
        System.out.println(CollectionUtils.arrayToList(source));
        System.out.println();
        dichotomyInsertSort(source);
        System.out.println("直接插入排序后");
        System.out.println(CollectionUtils.arrayToList(source));
    }
}
