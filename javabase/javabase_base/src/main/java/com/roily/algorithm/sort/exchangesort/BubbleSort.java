package com.roily.algorithm.sort.exchangesort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

/**
 * @classname：BubbleSort
 * @author: rolyfish
 * @description: 冒泡排序
 * @date: 2022/7/3 14:31
 */
public class BubbleSort {


    /**
     * 上浮
     *
     * @param source
     */
    public static void bubbleSortUp(int[] source) {
        int temp = 0;
        for (int i = source.length - 1; i > 0; i--) {
            //减i是因为，每次循环都会将，较小值上浮没必要比较到0
            for (int j = source.length - 1; j > source.length - i; j--) {
                if (source[j] < source[j - 1]) {
                    //交换
                    temp = source[j];
                    source[j] = source[j - 1];
                    source[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 下沉
     * 将最大值下沉
     *
     * @param source
     */
    public static void bubbleSortDown(int[] source) {
        int temp = 0;
        for (int i = 0; i < source.length; i++) {
            //减一是因为，每次循环都会将，较大值下沉没必要比较到0
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    //交换
                    temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {

        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 100);
        System.out.println("源集合：=》" + CollectionUtils.arrayToList(randomColl));
        bubbleSortUp(randomColl);
        System.out.println("up冒泡排序后：=》" + CollectionUtils.arrayToList(randomColl));
        System.out.println("================");

        final int[] randomColl2 = DirectInsertSort.createRandomColl(20, 10, 3000);
        System.out.println("源集合：=》" + CollectionUtils.arrayToList(randomColl2));
        bubbleSortDown(randomColl2);
        System.out.println("down冒泡排序后：=》" + CollectionUtils.arrayToList(randomColl2));

    }
}
