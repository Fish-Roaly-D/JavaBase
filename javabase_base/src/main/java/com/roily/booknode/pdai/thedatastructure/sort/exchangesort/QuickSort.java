package com.roily.booknode.pdai.thedatastructure.sort.exchangesort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

/**
 * @classname：QuickSort
 * @author: rolyfish
 * @description: 快速排序
 * @date: 2022/11/9 17:03
 */
public class QuickSort {

    public static <T extends Comparable> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable> void quickSort(T[] array, int l, int r) {
        if (l < r) {
            //基准元素确定位置并返回下标
            int midIndex = midIndex(array, l, r);
            //递归
            quickSort(array, l, midIndex - 1);
            quickSort(array, midIndex + 1, r);
        }
    }

    public static <T extends Comparable> int midIndex(T[] array, int l, int r) {
        //以第一个元素为基准
        int left = l;
        int right = r;
        T midEle = array[left];

        while (left < right) {
            //从右向左找出第一个小于基准的元素
            while (left < right && midEle.compareTo(array[right]) <= 0) {
                right--;
            }
            //将小的元素，移动到左边
            array[left] = array[right];
            //从左向右找出第一个大于基准的元素
            while (left < right && midEle.compareTo(array[left]) >= 0) {
                left++;
            }
            //将较大元素移动到右边
            array[right] = array[left];
        }
        array[left] = midEle;
        //以上确定了一个基准元素
        return left;
    }


    public static void main(String[] args) {

        final Integer[] randomColl = SortUtils.createRandomColl(20, 0, 100);
        SortUtils.print(randomColl);
        quickSort(randomColl);
        SortUtils.print(randomColl);

    }
}
