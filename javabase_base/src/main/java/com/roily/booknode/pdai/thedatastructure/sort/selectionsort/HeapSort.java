package com.roily.booknode.pdai.thedatastructure.sort.selectionsort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

/**
 * @classname：HeapSort
 * @author: rolyfish
 * @description: 堆排序
 * @date: 2022/11/9 14:00
 */
public class HeapSort {

    /**
     * 小顶堆向下调整
     *
     * @param array 原数组
     * @param start 下调节点的起始位置 一般为0，表示从第一个开始
     * @param end   终止下标，一般为数组最后一个下标
     * @param <T>
     */
    public static <T extends Comparable> void minHeapDown(T[] array, int start, int end) {
        //父节点，被下调的父节点
        int parent = start;
        //待上调子节点,默认左子节点，为左右子节点中较小的
        int son = 2 * parent + 1;
        //循环截止条件：没有子节点
        for (; son <= end; ) {
            /**
             * 防止下标越界，即存在左子节点，不存在右子节点
             * 右子节点较小
             */
            if (son < end && array[son].compareTo(array[son + 1]) > 0) {
                //选择较小的子节点
                son++;
            }
            // 父节点较大，则交换位置
            if (array[parent].compareTo(array[son]) > 0) {
                T temp = array[parent];
                array[parent] = array[son];
                array[son] = temp;
                //如果 parent被下调了，那么下调之后的位置也需要调整
                parent = son;
                //更新子节点
                son = 2 * son + 1;
            } else {
                //无需调整则跳出循环
                break;
            }
        }
    }

    /**
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void createMinHeap(T[] array) {
        int end = array.length - 1;
        //(n - 1) / 2为最后一个父节点，从他开始调整。调整完后得到一个小顶堆
        for (int parent = (end - 1) / 2; parent >= 0; parent--) {
            minHeapDown(array, parent, end);
        }
    }

    /**
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void heapSort(T[] array) {
        //转化为小顶堆
        createMinHeap(array);
        /**
         * 对小顶堆进行排序
         * - 首先堆顶元素是最小值，拿出来和数组最后一个元素进行交换
         * - 交换完成后，对剩余数组进行堆调整
         */
        for (int i = array.length - 1; i >=0 ; i--) {
            //堆顶元素
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            minHeapDown(array, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        final Integer[] randomColl = SortUtils.createRandomColl(20, 0, 100);
        SortUtils.print(randomColl);
        //createMinHeap(randomColl);
        heapSort(randomColl);
        SortUtils.print(randomColl);
    }
}
