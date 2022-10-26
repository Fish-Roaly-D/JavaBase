package com.roily.booknode.pdai._04fanx.fanxclass;

import com.roily.booknode.javatogod._05fanx.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Date: 2022/10/26/12:25
 * @Description:
 */
public class TestExtendAndSuper {
}


class TestExtendsA<T> {

    /**
     * 此方法目的是接受两个参数进行比较
     */
    void funA(T t1, T t2) {
        //强转
        Comparable c1 = (Comparable) t1;
        Comparable c2 = (Comparable) t2;
        System.out.println(c1.compareTo(c2));
    }

    public static void main(String[] args) {
        final TestExtendsA<Fruit> fruitTestExtendsA = new TestExtendsA<>();
        fruitTestExtendsA.funA(new Fruit(), new Fruit());
    }

}

class TestAB {

    static void funA(List<Comparable> list) {
        final Comparable comparable = list.get(0);
    }

    static void funB(List<? extends Comparable> list) {
        final Comparable comparable = list.get(0);
    }

    public static void main(String[] args) {
        //没有问题
        final ArrayList list1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        funA(list1);

        //ClassCastException
        final ArrayList list2 = new ArrayList<>(Collections.singletonList(new StringBuilder()));
        funA(list2);

        //通过不了类型检查
        final ArrayList<String> list3 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        // funA(list3);

        //没有问题
        final ArrayList listB1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        funB(listB1);

        //ClassCastException
        final ArrayList listB2 = new ArrayList<>(Collections.singletonList(new StringBuilder()));
        funB(listB2);

        // 可以
        final ArrayList<String> listB3 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        funB(listB3);
    }
}

class TestEA {

    static void extendsAdd(List<? extends Comparable> list) {
        final Comparable comparable = list.get(0);
    }

}

class TestSG {

    static void superGet(List<? super String> list) {
        list.add("z");
        //get得到的时String及String的父类，不能确定具体类型，没有意义
        final Object s = list.get(0);
    }

    static void superGet2(List<? super Comparable> list) {
        list.add("z");
        list.add(1);
        final Object s = list.get(0);
    }

    public static void main(String[] args) {
        final List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        final List<Comparable> comparableList = new ArrayList<>(Arrays.asList(1, 2, 3));
        // 报错
        // superGet(integers);

        superGet(comparableList);
        for (int i = 0; i < comparableList.size(); i++) {
            System.out.println(comparableList.get(i));
        }
    }
}

class Test7 {



}