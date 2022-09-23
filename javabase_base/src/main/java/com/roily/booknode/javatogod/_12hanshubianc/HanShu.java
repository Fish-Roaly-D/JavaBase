package com.roily.booknode.javatogod._12hanshubianc;

import com.google.common.cache.RemovalListener;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Date: 2022/09/23/14:46
 * @Description:
 */
public class HanShu {


    @Test
    public void test1() {

        Consumer<Person> method1x = (person) -> {
        };
        //简单方法引用，无参数
        final Consumer<Person> method1 = Person::method1;


        final BiConsumer<Person, String> method2x = (person, str) -> {
            person.method2(str);
        };
        //一个参数方法，范型：第一个调用方，第二个方法参数
        final BiConsumer<Person, String> method2 = Person::method2;



        MyDemoI<Person,String,String> myDemoI = Person::method2;

        myDemoI.method(new Person(),"","");

        final Person person = new Person();
        final BiConsumer<String, String> stringStringBiConsumer = person::method2;


        Predicate<String> predicate1 =  (String ele) -> ele.startsWith("");
        Predicate<String> predicate2 =  (String ele) -> ele.startsWith("");
        predicate1.and(predicate2);


    }


}

class Person {

    public void method1() {
        System.out.println();
    }

    public void method2(String str1) {
        System.out.println("method2(String str1)");
    }

    public void method2(String str1, String str2) {
        System.out.println("method2(String str1, String str2)");
    }
}

interface MyDemoI<T, K, V> {

    void method(T t, K k, V v);

}