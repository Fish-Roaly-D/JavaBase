package com.roily.algorithm.sort.radixsort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname：RadixSort
 * @author: rolyfish
 * @description: 基数排序
 * @date: 2022/7/6 02:30
 */
public class RadixSort {


    /**
     * 获取最大基数
     *
     * @param source 数组
     * @return 最大基数
     */
    public static int getMaxRadix(int[] source) {
        int radix = 0;
        int max = source[0];
        for (int ele : source) {
            max = Math.max(max, ele);
        }
        do {
            radix++;
        } while ((max /= 10) > 0);
        return radix;
    }


    public static void radixSort(int[] source) {

        //获取最大基数
        final int maxRadix = getMaxRadix(source);
        //创建十个桶，这里使用ArrayList
        final List<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < maxRadix; i++) {
            int index;
            ArrayList<Integer> arrayList;
            //分配 数据放在哪个桶里
            for (int ele : source) {
                //先取整、再取余。 找到对应的桶
                index = ele / (int) Math.pow(10, i) % (int) Math.pow(10, 1);
                arrayList = buckets.get(index);
                arrayList.add(ele);
            }

            int indexX = 0;
            //收集
            for (int j = 0; j < buckets.size(); j++) {
                final ArrayList<Integer> tTemp = buckets.get(j);
                //桶不为空，写会集合
                while (!tTemp.isEmpty()) {
                    source[indexX++] = tTemp.get(0);
                    //移出桶
                    tTemp.remove(0);
                }
            }
        }
    }

    public static void main(String[] args) {

        final int[] randomColl = DirectInsertSort.createRandomColl(30, 10, 150);
        System.out.println("源集合：=》" + CollectionUtils.arrayToList(randomColl));
        radixSort(randomColl);
        System.out.println("基数排序后：=》" + CollectionUtils.arrayToList(randomColl));
    }

}
