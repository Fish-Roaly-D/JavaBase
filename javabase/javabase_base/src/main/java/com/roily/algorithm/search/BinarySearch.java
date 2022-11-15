package com.roily.algorithm.search;

/**
 * @classname：BinarySearch
 * @author: rolyfish
 * @description: 二分查找
 * @date: 2022/7/19 22:55
 */
public class BinarySearch {


    /**
     * 二分查找-非递归实现
     * 思想：
     * 基准元素大于中间元素，原中间下标加一置为 左指针
     * 基准元素小于中间元素，原中间下标减一置为，右指针
     *
     * @param source
     * @param element
     * @return
     */
    public static int binarySearchWithOut(int[] source, int element) {
        int prev = 0;
        int last = source.length;
        int mid = 0;
        while (prev <= last) {
            mid = (prev + last) / 2;
            if (element == source[mid]) {
                return mid;
            } else if (element <= source[mid]) {
                //左
                last = mid - 1;
            } else {
                prev = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] source, int prev, int last, int element) {
        int mid = (prev + last) / 2;
        if (prev <= last) {
            if (element == source[mid]) {
                return mid;
            } else if (element > source[mid]) {
                return binarySearch(source, mid + 1, last, element);
            } else {
                return binarySearch(source, prev, mid - 1, element);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        final int[] source = new int[]{1, 3, 5, 7, 8, 9, 11, 12, 13, 15, 16, 16, 22, 23, 34, 56, 211,};
        System.err.println("二分查找非递归实现");
        final int index = binarySearchWithOut(source, 16);
        System.out.println("基准元素16，查找得到元素下标为" + index + "  " + "对应元素为：" + source[index]);

        Thread.sleep(111);

        System.err.println("二分查找递归实现");
        final int index2 = binarySearch(source, 0, source.length, 16);
        System.out.println("基准元素16，查找得到元素下标为" + index + "  " + "对应元素为：" + source[index2]);
    }


}
