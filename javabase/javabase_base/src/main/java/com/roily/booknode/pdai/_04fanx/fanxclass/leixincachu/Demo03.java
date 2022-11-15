package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2022/10/27/11:18
 * @Description: 限定通配符
 */
@Data
public class Demo03 {


    public static void method1(List<? super String> list ) {
        /**
         * 可以取，取到的是Object，想要用得自己强转，没意义
         */
        final Object o = list.get(0);
        String s = (String)o;

        /**
         * 可以  add
         */
        list.add("");

    }

    public static  void method(List<? extends Comparable> list ) {
        final Comparable comparable = list.get(0);

        /**
         * 不让add，怕add过后，这个list取值的时候会出选 ClassCastException
         *
         * 由于类型擦除，这里可以add所有Comparable得派生类型，比如Integer
         */
        // list.add("");
    }

}
