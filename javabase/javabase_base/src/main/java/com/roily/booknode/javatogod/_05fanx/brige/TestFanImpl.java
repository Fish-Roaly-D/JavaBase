package com.roily.booknode.javatogod._05fanx.brige;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/08/26/11:08
 * @Description:
 */
public class TestFanImpl {

    @Test
    public void testCollection() {
        final List<String> list = new ArrayList<>(10);
        list.add("可可爱爱");
        System.out.println(list.get(0));
    }

}

/**
 * 实现接口并指定范型类型
 *
 * 指定范型类型，那么CompareTo方法也必须指定类型，如果不指定那么就会替换为其左边界Object
 * 编译后Comparable<String>的类型被擦除，对应的抽象接口方法变为compareTo(Object o)
 * 那么直接导致子类未能实现compareTo方法
 * 编译器检测到了，就给生成一个桥接方法compareTo(Object object)，桥接方法内部调用子类实现的compareTo(String o)
 */
class ImplInterfaceZD implements Comparable<String> {
    @Override
    public int compareTo(String o) {
        return this.compareTo(o);
    }
}


/**
 * 实现接口不指定范型类型
 *
 * 不指定范型类型，编译期将范型类型擦除，并在使用时替换为最左边界类型 Object
 * 对应抽象方法变为compareTo(Object o)
 * 此刻不存在桥接方法
 */
class ImplInterfaceNotZD implements Comparable {

    @Override
    public int compareTo(@NotNull Object o) {
        return hashCode() - o.hashCode();
    }

}


