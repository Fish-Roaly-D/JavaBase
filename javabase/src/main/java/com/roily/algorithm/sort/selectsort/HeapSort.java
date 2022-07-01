package com.roily.algorithm.sort.selectsort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @classname：HeapSort
 * @author: rolyfish
 * @description: 堆排序
 * @date: 2022/7/2 00:09
 */
public class HeapSort {
    @Test
    public void testPriorityQueue() {

        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 30);
        System.out.println("源集合");
        System.out.println(CollectionUtils.arrayToList(randomColl));
        System.out.println("小顶堆");
        final PriorityQueue<Integer> descHeap = new PriorityQueue<>((Collection<? extends Integer>) CollectionUtils.arrayToList(randomColl));
        descHeap.forEach(element -> {
            System.out.printf(element + ",");
        });
        System.out.println();
        System.out.println("大顶堆");
        final PriorityQueue<Integer> ascHeap = new PriorityQueue<>((ele1, ele2) -> ele1 > ele2 ? -1 : 1);
        for (int ele : randomColl) {
            ascHeap.add(ele);
        }
        ascHeap.forEach(element -> {
            System.out.printf(element + ",");
        });
    }
}

class HeapSortTest {


}