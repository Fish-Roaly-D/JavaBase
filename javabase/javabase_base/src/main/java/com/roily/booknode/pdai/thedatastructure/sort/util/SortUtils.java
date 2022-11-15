package com.roily.booknode.pdai.thedatastructure.sort.util;


/**
 * @classname：SortUtils
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/7 23:51
 */
public class SortUtils {
    /**
     * @param size      数组大小
     * @param lowLimit  下限
     * @param highLimit 上限
     * @return 集合
     */
    public static Integer[] createRandomColl(int size, int lowLimit, int highLimit) {
        final Integer[] coll = new Integer[size];
        for (int i = 0; i < size; i++) {
            coll[i] = lowLimit + (int) (Math.random() * (highLimit - lowLimit));
        }
        return coll;
    }

    public static <T> void print(T[] t) {
        final StringBuilder sb = new StringBuilder("[");
        for (T t1 : t) {
            sb.append(t1 + "、");
        }
        sb.replace(sb.lastIndexOf("、"), sb.lastIndexOf("、") + 1, "]");
        System.out.println(sb);
    }


}
