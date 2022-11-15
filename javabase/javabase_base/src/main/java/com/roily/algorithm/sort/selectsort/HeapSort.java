package com.roily.algorithm.sort.selectsort;

import com.roily.algorithm.sort.insertsort.DirectInsertSort;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @classname：HeapSort
 * @author: rolyfish
 * @description: 堆排序
 * @date: 2022/7/2 00:09
 */
public class HeapSort {

    @SuppressWarnings("unchecked")
    @Test
    public void testPriorityQueue() {

        final int[] randomColl = DirectInsertSort.createRandomColl(20, 10, 30);
        System.out.println("源集合");
        System.out.println(CollectionUtils.arrayToList(randomColl));
        System.out.println("小顶堆");
        final PriorityQueue<Integer> descHeap = new PriorityQueue<>((Collection<? extends Integer>) CollectionUtils.arrayToList(randomColl));
        descHeap.forEach(element -> {
            System.out.printf(element + ", ");
        });
        System.out.println();
        System.out.println("大顶堆");
        final PriorityQueue<Integer> ascHeap = new PriorityQueue<>((ele1, ele2) -> ele1 > ele2 ? -1 : 1);
        for (int ele : randomColl) {
            ascHeap.add(ele);
        }
        ascHeap.forEach(element -> {
            System.out.printf(element + ", ");
        });
    }
}

class HeapSortTest {

    static int[] heap;

    /**
     * @param k 为父节点
     * @param x 父节点对应元素
     */
    void siftDownComparable(int k, int x,int[] source) {
        int size = source.length;
        //一半
        int half = size >>> 1;
        while (k < half) {
            //当前为左子节点下标，后续更新为较小子节点下标
            int l = (k << 1) + 1;
            //c当前为左子节点，后续为左右子节点较小值
            int c = source[l];
            int right = l + 1;
            //右子节点小于左子节点，更新l和c
            if (right < size && c > source[right]) {
                c = source[l = right];
            }
            //父节点小于较小子节点，跳出循环
            if (x <= c) {
                break;
            }
            source[l] = source[k];
            //更新父节点
            source[k] = c;
            //记录child，因为child对应元素被移动，需要检查其子节点是否合理
            k = l;
        }

    }

    /**
     * 生成小顶堆
     * @param source
     */
    private void createHeap(int[] source) {
        for (int i = (source.length >>> 1) - 1; i >= 0; i--){
            siftDownComparable(i, source[i],source);
        }
    }

    public static void main(String[] args) {
        final HeapSortTest heapSortTest = new HeapSortTest();
        heap = DirectInsertSort.createRandomColl(10, 10, 90);
        System.out.println("原数组");
        System.out.println(CollectionUtils.arrayToList(heap));
        heapSortTest.createHeap(heap);
        System.out.println("生成一个小顶堆");
        System.out.println(CollectionUtils.arrayToList(heap));


        final int[] ints = new int[10];

        System.out.println("堆排序后");
        for (int i = 0; i < heap.length; i++) {
            //待生成堆集合
            final int[] tempColl = Arrays.copyOfRange(heap, i, heap.length -1);
            heapSortTest.createHeap(tempColl);
            ints[i] =tempColl[0];
        }
        System.out.println(CollectionUtils.arrayToList(ints));
    }
}