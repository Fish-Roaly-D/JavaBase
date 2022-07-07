package com.roily.algorithm.sort.countsort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @classname：CountSort
 * @author: rolyfish
 * @description: todo
 * @date: 2022/7/6 23:43
 */
public class CountSort {


    public static void main(String[] args) {
        int[] source = DirectInsertSort.createRandomColl(20, 0, 20);
        System.out.println("源数组：=》"+CollectionUtils.arrayToList(source));
        countSort(source);
        System.out.println("计数排序后：=》"+CollectionUtils.arrayToList(source));
    }

    /**
     * 计算任意数组的最大元素值，用于生成辅助数组
     *
     * @param source
     * @return
     */
    public static int maxElement(int[] source) {
        Assert.isTrue(null != source && source.length > 0, " 数组不可为空");
        int max = source[0];
        for (int ele : source) {
            max = Math.max(ele, max);
        }
        return max;
    }


    public static void countSort(int[] source) {
        //计数数组个数
        final int count = maxElement(source) + 1;
        //初始化计数数组
        int[] counts = new int[count];
        //计算各个元素出现的次数
        for (int element : source) {
            counts[element]++;
        }
        //计算任意元素存在多少比其小的元素个数,下标从1开始
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        //需要一个辅助数组
        final int[] target = new int[source.length];
        //从后往前
        for (int i = source.length - 1; i >= 0; i--) {
            target[counts[source[i]] - 1] = source[i];
            //计数器减一
            counts[source[i]]--;
        }
        System.arraycopy(target, 0, source, 0, source.length);
    }


}
