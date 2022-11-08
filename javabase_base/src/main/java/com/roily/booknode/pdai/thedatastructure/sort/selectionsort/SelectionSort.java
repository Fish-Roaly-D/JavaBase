package com.roily.booknode.pdai.thedatastructure.sort.selectionsort;

import com.roily.booknode.javatogod._08date.Main;
import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

/**
 * @Date: 2022/11/08/14:44
 * @Description: 直接选择排序
 */
public class SelectionSort {


    public static <T extends Comparable> void selectionSort(T[] array) {
        selectionSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable> void selectionSort(T[] array, int last) {
        selectionSort(array, 0, last, true, true);
    }


    public static <T extends Comparable> void selectionSort(T[] array, int first, int last) {
        selectionSort(array, first, last, true, true);
    }

    public static <T extends Comparable> void selectionSort(T[] array, int first, int last, boolean flag) {
        selectionSort(array, first, last, flag, true);
    }

    /**
     * 直接选择排序
     * @param array
     * @param first 排序上界
     * @param last  排序下届
     * @param flag  二进制？
     * @param desc  fales 降序   true升序
     * @param <T>
     */
    public static <T extends Comparable> void selectionSort(T[] array, int first, int last, boolean flag, boolean desc) {
        if (!flag) {
            first--;
            last--;
        }
        //split 为无序序列首个元素
        for (int split = first; split <= last; split++) {
            //最值下标
            int tempIndexTemp = split;
            int tempIndex = split + 1;
            for (; tempIndex <= last; tempIndex++) {
                if (desc) {
                    //tempIndex 为新的最值
                    if (array[tempIndex].compareTo(array[tempIndexTemp]) < 0) {
                        tempIndexTemp = tempIndex;
                    }
                } else {
                    //tempIndex 为新的最值
                    if (array[tempIndex].compareTo(array[tempIndexTemp]) > 0) {
                        tempIndexTemp = tempIndex;
                    }
                }
            }
            //交换位置
            if (tempIndexTemp != split) {
                //缓存极值
                T temp =array[tempIndexTemp];
                array[tempIndexTemp] = array[split];
                array[split] = temp;
            }
        }
    }

    public static void main(String[] args) {
        final Integer[] randomColl = SortUtils.createRandomColl(30, 5, 100);
        SortUtils.print(randomColl);
        selectionSort(randomColl);
        SortUtils.print(randomColl);
    }
}