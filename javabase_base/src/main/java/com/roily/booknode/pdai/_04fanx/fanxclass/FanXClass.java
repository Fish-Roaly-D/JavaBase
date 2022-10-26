package com.roily.booknode.pdai._04fanx.fanxclass;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Date: 2022/10/26/10:27
 * @Description:
 */
@Data
@AllArgsConstructor
public class FanXClass<T> {

    T t;

    void method1(T t) {
        System.out.println("T  t :" + t.getClass() + "和  FanXClass<T> 类型一致");
    }

    T method2(T t) {
        return t;
    }

    public static void main(String[] args) {

        final FanXClass<String> stringFanXClass = new FanXClass<>("FanXClass");
        final String t = stringFanXClass.t;
        stringFanXClass.method1("");

        final FanXClass<Integer> intFanXClass = new FanXClass<>(1);
        final Integer t2 = intFanXClass.t;
        intFanXClass.method1(t2);

    }
}
