package com.roily.algorithm.sort.bucksort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @classname：BuckSort
 * @author: wolfish
 * @description: 桶排序
 * @date: 2022/7/7 20:59
 */
public class BuckSort {


    /**
     * 计算待排序集合最大值
     *
     * @return max
     */
    public static int collMax(int[] source) {
        int max = source[0];
        for (int element : source) {
            max = Math.max(element, max);
        }
        return max;
    }

    /**
     * 计算待排序集合最小值
     *
     * @return min
     */
    public static int collMin(int[] source) {
        int min = source[0];
        for (int element : source) {
            min = Math.min(element, min);
        }
        return min;
    }


    public static void bucketSort(int[] source) {
        //获取最值
        int max = collMax(source);
        int min = collMin(source);
        //确定桶的个数n
        int bucketNum = max - min;
        //初始化桶
        List<ArrayList<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        //将元素放入桶内
        for (int value : source) {
            //元素对应桶下标
            int index = (int) ((value - min) / (max - min + 1.0) * bucketNum);
            buckets.get(index).add(value);
        }
        //桶内排序
        for (ArrayList<Integer> integers : buckets) {
            Collections.sort(integers);
        }
        //合并
        int j = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                source[j++] = value;
            }
        }
    }

    public static void main(String[] args) {
        final int[] randomColl = DirectInsertSort.createRandomColl(20, 5, 35);
        System.out.println("原集合：=>" + CollectionUtils.arrayToList(randomColl));
        bucketSort(randomColl);
        System.out.println("桶排序:=>" + CollectionUtils.arrayToList(randomColl));
    }

}
