package com.roily.algorithm.sort.insertsort;

import org.springframework.util.CollectionUtils;

/**
 * @classname：XierInsertSort
 * @author: rolyfish
 * @description: 希尔插入排序
 * @date: 2022/7/1 12:17
 */
public class XiErInsertSort {

    /**
     * 希尔排序是对直接插入排序的一种优化
     * 直接插入排序的缺点：每次循环只插入一个值，对于有序集合友好，对于杂乱集合，需要频繁移动元素
     * 希尔排序优化思路：将源集合以某个增量分组，对各分组内的元素进行直接插入排序（由于增量的存在移动元素次数不再频繁）
     * <p>
     * 增量选择：一般为集合长度一半，依次除二，直到为1。增量的选择不互为倍数
     *
     * @param source 源集合
     */
    public static void xiErInsertSort(int[] source) {
        //增量
        int step = 0;
        int temp = 0;
        for (step = source.length / 2; step > 0; step /= 2) {
            //step为分组后的待排序元素,对其进行直接插入排序
            for (int j = step; j < source.length; j++) {
                temp = source[j];
                int i = j - step;
                while (i >= 0 && temp < source[i]) {
                    source[i + step] = source[i];
                    i -= step;
                }
                source[i + step] = temp;
            }
        }
    }

    public static void main(String[] args) {
        final int[] randomColl = DirectInsertSort.createRandomColl(17, 10, 20);
        System.out.println("希尔排序前");
        System.out.println(CollectionUtils.arrayToList(randomColl));
        xiErInsertSort(randomColl);
        System.out.println("希尔排序后");
        System.out.println(CollectionUtils.arrayToList(randomColl));

    }

}
