package com.roily.booknode.pdai.thedatastructure.sort.InsertionSort;

import com.roily.booknode.pdai.thedatastructure.sort.util.SortUtils;

public class XiErInsertSort {

    public static <T extends Comparable> void xiErInsertSort(T[] source) {
        xiErInsertSort(source, 0, source.length - 1, source.length / 2, true);
    }

    /**
     * 希尔排序是对直接插入排序的一种优化
     * 直接插入排序的缺点：每次循环只插入一个值，对于有序集合友好，对于杂乱集合，需要频繁移动元素
     * 希尔排序优化思路：将源集合以某个增量分组，对各分组内的元素进行直接插入排序（由于增量的存在移动元素次数不再频繁）
     * <p>
     * 增量选择：一般为集合长度一半，依次除二，直到为1。增量的选择不互为倍数
     *
     * @param source 源集合
     */
    public static <T extends Comparable> void xiErInsertSort(T[] source, int first, int last, int gap, boolean flag) {
        if (!flag) {
            first--;
            last--;
        }

        gap = Math.min(gap, source.length);

        //存储每次直接插入排序的待插入元素
        T temp;

        //gap为步长，每次除二， 直到gap = 1
        for (; gap >= 1; gap /= 2) {
            //共gap - first组（0 - gap-1），对每一组进行直接插入排序
            for (int i = 0; i < gap; i++) {
                /**
                 * 0 gap 2gap
                 * 1 gap+1 2gap+1
                 * ...
                 * gap-1 2gap-1 3gap-1
                 */

                /**
                 *  对每一组进行直接插入排序
                 *
                 *  有序序列  j-2gap j-gap
                 *  无序序列  j j+gap j+2gap
                 *
                 *  j为待插入无序序列首个元素
                 */
                int j = i + gap;
                for (; j <= /*source.length-1*/last; j += gap) {
                    //j为待插入元素，即分组后无序序列的首个元素，给j找个合适位置落下

                    //遍历 j-gap j-2gap ...
                    int m = j - gap;
                    for (; m >= /*0*/first; m -= gap) {
                        //待插入元素比，source[m] 大于等于，插入位置确定了 m+gap
                        if (source[j].compareTo(source[m]) >= 0) {
                            break;
                        }
                    }
                    //不相等才全体后移，相等插入位置即是当前位置，i+gap
                    if (m != j - gap) {
                        temp = source[j];
                        int q = j - gap;
                        //m+gap m+2gap 后移，
                        for (; q > m; q -= gap) {
                            source[q + gap] = source[q];
                        }
                        source[m + gap] = temp;
                    }
                }
            }
        }
    }


    public static <T extends Comparable> void xiErInsertSort2(T[] source) {
        xiErInsertSort2(source, 0, source.length - 1, source.length / 2, true);
    }


    public static <T extends Comparable> void xiErInsertSort2(T[] source, int first, int last, int gap, boolean flag) {
        if (!flag) {
            first--;
            last--;
        }

        gap = Math.min(gap, source.length);

        //存储每次直接插入排序的待插入元素
        T temp;

        //gap为步长，每次除二， 直到gap = 1
        for (; gap >= 1; gap /= 2) {
            for (int i = 0; i < gap - first; i++) {
                xiErGroupSort(source, i, last, gap);
            }
        }
    }

    /**
     * 对某个组进行直接插入排序
     *
     * @param source
     * @param first
     * @param last
     * @param gap
     * @param <T>
     */
    public static <T extends Comparable> void xiErGroupSort(T[] source, int first, int last, int gap) {
        T temp;
        int j = first + gap;
        for (; j <= /*source.length-1*/last; j += gap) {
            int m = j - gap;
            for (; m >= /*0*/first; m -= gap) {
                if (source[j].compareTo(source[m]) >= 0) {
                    break;
                }
            }
            if (m != j - gap) {
                temp = source[j];
                int q = j - gap;
                //m+gap m+2gap 后移，
                for (; q > m; q -= gap) {
                    source[q + gap] = source[q];
                }
                source[m + gap] = temp;
            }
        }
    }

    public static void main(String[] args) {
        final Integer[] randomColl = SortUtils.createRandomColl(15, 0, 45);
        SortUtils.print(randomColl);
        xiErInsertSort(randomColl, 5, 10, 5, true);
        SortUtils.print(randomColl);

        final Integer[] randomColl2 = SortUtils.createRandomColl(15, 0, 45);
        SortUtils.print(randomColl2);
        xiErInsertSort(randomColl2, 5, 10, 5, true);
        SortUtils.print(randomColl2);

    }
}