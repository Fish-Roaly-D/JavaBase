package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2022/10/27/11:18
 * @Description: 限定通配符
 */


@Data
public class Demo04<T> implements Demo04Interface<T> {

    T t;

    @Override
    public T value() {
        return null;
    }

    public static <T> void valueT(T t) {
        T tTemp = t;
    }

    public static <T extends Number> void valueT(T t) {
        T tTemp = t;
    }

}


interface Demo04Interface<T> {
    T value();
}