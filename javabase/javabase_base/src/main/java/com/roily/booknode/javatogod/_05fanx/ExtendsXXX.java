package com.roily.booknode.javatogod._05fanx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/08/26/11:36
 * @Description:
 */
public class ExtendsXXX {

    public static <T extends List<E>, E extends Comparable<E>> void max(List<E> list) {
        E max = list.get(0);
        for (E e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        System.out.println("最大值=>" + max);
    }

}
