package com.roily.booknode.javatogod._09sugar;

import java.util.List;

/**
 * @Date: 2022/09/05/11:31
 * @Description:
 */
public class TestSugar {

    public void method1(List<String> list){
        final String s = list.get(0);
        list.add("123");
    }

    /**
     * extends适合get
     * @param list
     */
    public void method2(List<? extends String> list){
        final String s = list.get(0);
        list.add(null);
    }

    /**
     * extends适合add
     * @param list
     */
    public void method3(List<? super String> list){
        //得到obj没有意义
        final Object o =  list.get(0);
        //强转可能会造成，Cast异常
        final Comparable s = (Comparable) list.get(0);
        list.add("null");

    }

}
