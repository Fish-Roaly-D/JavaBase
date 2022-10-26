package com.roily.booknode.pdai._04fanx.fanxclass;

import java.io.Serializable;

/**
 * @Date: 2022/10/26/15:31
 * @Description:
 */
public class DuoXianZhi {

    static <T extends Comparable<? super T> & CharSequence> void method(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        method("123");
    }
}
