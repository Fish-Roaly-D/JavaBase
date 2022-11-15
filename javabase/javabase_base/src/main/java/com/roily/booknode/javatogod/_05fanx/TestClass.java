package com.roily.booknode.javatogod._05fanx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @classname：TestClass
 * @author: rolyfish
 * @description:
 * @date: 2022/8/28 15:15
 */
public class TestClass<T> {

    T t;

    public T test(T t, List<T> list) {

        Comparable ct = (Comparable) t;
        ct.compareTo("");

        return null;
    }

}

class TestClassy<T> {
    T t;

    public T test(T t, List<T> list) {


        return null;
    }
}

class TestClass2 {
    public void test(List<?> list) {
        //list.add("");
        final Object o = list.get(0);
        System.out.println(o);
    }

    public static void main(String[] args) {
        final TestClass2 testClass2 = new TestClass2();
        testClass2.test(new ArrayList<Integer>(Arrays.asList(1, 2)));
        testClass2.test(new ArrayList<String>(Arrays.asList("1", "2")));
        testClass2.test(new ArrayList<Comparable>(Arrays.asList(1, 2)));
    }
}

class TestClassC<T> {
    T t;

    public void test(T t1, T t2) {
        final Comparable t1c = (Comparable) t1;
        System.out.println(t1c.compareTo(t2));

    }

    public static void main(String[] args) {
        final TestClassC<List> stringTestClassC = new TestClassC<>();
        stringTestClassC.test(Collections.emptyList(), Collections.emptyList());
    }
}

class TestClassE {

    public void test(List<? extends Comparable> list) {

        list.forEach(System.out::print);

    }

    public static void main(String[] args) {

        final TestClassE testClassE = new TestClassE();

        testClassE.test(Arrays.asList("a", "b"));

        //testClassE.test(Arrays.asList(Collections.emptyList(),Collections.emptyList()));

    }
}

class TestClassS {
    public void test(List<? super Fruit> list) {
        list.forEach(System.out::print);
    }

    public static void main(String[] args) {
        final TestClassS testClassS = new TestClassS();
        testClassS.test(new ArrayList<>(Arrays.asList("a", "b")));
    }
}

class TestClassS1 {
    public void test(List<? super Apple> list) {
        list.forEach(System.out::print);
    }

    public static void main(String[] args) {
        final TestClassS1 testClassS1 = new TestClassS1();
        testClassS1.test(new ArrayList<Apple>(Arrays.asList(new Apple())));
    }
}

class TestClassSa {
    public void test(List<? super Number> list) {
        list.add(1L);
        list.add(2L);

        final Number number = (Number)list.get(0);
        System.err.println(number);

    }
    public static void main(String[] args) {
        final TestClassSa testClassSa = new TestClassSa();
        final ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        numbers.forEach(System.out::print);
        System.out.println();
        testClassSa.test(numbers);
        numbers.forEach(System.out::print);
    }
}

//ClassCastException  只能是Object类型
//final Apple object = (Apple) list.get(0);