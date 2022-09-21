package com.roily.booknode.javatogod._05fanx;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/08/26/11:08
 * @Description:
 */
public class TestFanX {

    @Test
    public void testCollection() {
        final List<String> list = new ArrayList<>(10);
        list.add("可可爱爱");
        System.out.println(list.get(0));
    }

    @Test
    public void testxx() {


    }

}

/**
 * 指定范型类型，那么CompareTo方法也必须指定类型，如果不指定那么就会替换为其左边界Object
 * 编译后Comparable<MyNumericValue>的类型被擦除，变为Comparable<Object>
 * 那么直接导致未能实现compareTo方法
 * 编译器检测到了，就给生成一个桥接方法compareTo(Object object)
 */
class MyNumericValue implements Comparable<MyNumericValue> {
    private int value;
    @Override
    public int compareTo(MyNumericValue o) {
        return this.value - o.value;
    }
}


class MyNumericValue2 implements Comparable {
    private int value;
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

