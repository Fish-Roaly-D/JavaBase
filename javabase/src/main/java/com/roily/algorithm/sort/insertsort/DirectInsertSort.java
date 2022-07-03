package com.roily.algorithm.sort.insertsort;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @classname：DirectInsertSort
 * @author: rolyfish
 * @description: 直接插入排序
 * @date: 2022/7/1 00:00
 */
public class DirectInsertSort {

    /**
     * @param size      数组大小
     * @param lowLimit  下限
     * @param highLimit 上限
     * @return int[]
     */
    public static int[] createRandomColl(int size, int lowLimit, int highLimit) {

        Assert.isTrue(size>0,"数组长度需要大于0");
        final int[] coll = new int[size];
        for (int i = 0; i < size; i++) {
            coll[i] = lowLimit + (int) (Math.random() * (highLimit - lowLimit));
        }
        return coll;
    }

    /**
     * 直接插入排序
     * 关键在于：在已有序集合中从后向前找到待排序元素合适的插入下标
     *
     * @param source 源集合
     */
    public static void directInsertSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            //待排序元素
            int temp = source[i];
            int j;
            //在已有序集合中找到合适位置
            for (j = i - 1; j >= 0; j--) {
                //大于temp的元素后移
                if (temp < source[j]) {
                    source[j + 1] = source[j];
                } else {
                    //找到需要插入的位置j+1，跳出循环
                    break;
                }
            }
            source[j + 1] = temp;
        }
    }

    public static void main(String[] args) {

        final int[] source = createRandomColl(20, -10, 15);
        System.out.println("源集合：");
        System.out.println(CollectionUtils.arrayToList(source));
        System.out.println();
        directInsertSort(source);
        System.out.println("直接插入排序后");
        System.out.println(CollectionUtils.arrayToList(source));
    }

}
