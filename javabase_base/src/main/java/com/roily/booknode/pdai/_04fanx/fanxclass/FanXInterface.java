package com.roily.booknode.pdai._04fanx.fanxclass;

/**
 * @Date: 2022/10/26/10:27
 * @Description:
 */

public interface FanXInterface<T> {
    T method(T t);
}
class FanXInterfaceImpl<T> implements FanXInterface<T>{
    @Override
    public T method(T t) {
        return t;
    }

    public static void main(String[] args) {
        final FanXInterface<String> fanXInterface = new FanXInterfaceImpl<>();
        fanXInterface.method("str");
    }
}