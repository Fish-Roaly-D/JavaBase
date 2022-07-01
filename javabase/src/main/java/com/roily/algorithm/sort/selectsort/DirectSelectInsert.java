package com.roily.algorithm.sort.selectsort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.springframework.util.CollectionUtils;

/**
 * @classname：DirectSelectInsert
 * @author: rolyfish
 * @description: 直接选择排序
 * @date: 2022/7/1 13:20
 */
public class DirectSelectInsert {


    public static void directSelectInsert(int[] source) {
        //待排序记录最小值
        int min = 0;
        //最小值下标
        int minIndex = 0;
        for (int i = 0; i < source.length - 1; i++) {

            min = source[i];
            minIndex = i;
            for (int j = i; j < source.length; j++) {
                if (source[j] < min){
                    min = source[j];
                    minIndex = j;
                }
            }
            //交换
            source[minIndex] = source[i];
            source[i] = min;
        }
    }

    public static void main(String[] args) {
        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 20);
        System.out.println("直接选择排序前");
        System.out.println(CollectionUtils.arrayToList(randomColl));
        directSelectInsert(randomColl);
        System.out.println("直接选择排序后");
        System.out.println(CollectionUtils.arrayToList(randomColl));

    }

}
