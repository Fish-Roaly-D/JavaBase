package com.roily.booknode.pdai.thedatastructure.sort.exchangesort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

/**
 * @classname：BubbleSort
 * @author: rolyfish
 * @description:
 * @date: 2022/11/9 16:42
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     * @param start 起始下标
     * @param end   终止下标
     * @param <T>
     */
    public static <T extends Comparable> void bubbleSort(T[] array, int start, int end) {
        /**
         * 每趟循环会对数组相邻两个元素，两两对比，大的下沉小的上浮，选举出最大元素在数组右侧，循环此操作直至数组有序
         */
        boolean flag = true;
        //缓存
        T temp = null;
        for (int i = start; i <= end; i++) {
            for (int j = start; j < end - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    if (flag) flag = false;
                }
            }
            //如果没有发生交换，说明数组已经有序，跳出循环
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        final Integer[] randomColl = SortUtils.createRandomColl(20, 0, 100);
        SortUtils.print(randomColl);
        bubbleSort(randomColl, 5, randomColl.length - 1);
        SortUtils.print(randomColl);

    }

}
