package com.roily.split;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName HashMapSpliter.java
 * @author: RoilyFish
 * @date: 2022/4/21 0:08
 */
public class HashMapSpliter {


    @Test
    public void test01() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        Spliterator<Map.Entry<String, Object>> spliterator = map.entrySet().spliterator();
        while (spliterator.tryAdvance((a) -> {
            System.err.println(a.getValue());
        })) ;
    }

    @Test
    public void test03() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        Spliterator<Map.Entry<String, Object>> spliterator = map.entrySet().spliterator();

        spliterator = spliterator.trySplit();
        spliterator = spliterator.trySplit();

        spliterator.forEachRemaining((node)->{
            System.err.println(node.getValue());
        });
    }

    @Test
    public void test02() {
        Map<MyKey, Object> map = new HashMap<MyKey, Object>();
        MyKey myKey = new MyKey();
        MyKey myKey2 = new MyKey();

        map.put(new MyKey(), null);
        map.put(new MyKey(), 3);
        map.put(new MyKey(), 4);
        map.put(new MyKey(), 4);
        map.put(new MyKey(), 4);
        map.put(new MyKey(), 4);
        map.put(new MyKey(), 4);
        map.put(new MyKey(), 4);
        map.put(new MyKey(), 4);
        Spliterator<Map.Entry<MyKey, Object>> spliterator = map.entrySet().spliterator();
        while (spliterator.tryAdvance((a) -> {
            System.err.println(a.getValue());
        })) ;
    }


    public void mmtest(myClass<String> action) {

        String abc = "abc";

        action.accept(abc);

        int i = 10;

        while (i-- > 0) {

            System.out.println(abc);

            if (i == 5) return;

        }
    }

    public void mtest(Consumer<String> action) {
        String abc = "abc";
        action.accept(abc);
    }

    @Test
    public void test() {

        mtest((str) -> {
            System.out.println(str);
        });
    }


    public static void main(String[] args) {
        HashMapSpliter hashMapSpliter = new HashMapSpliter();

        hashMapSpliter.mmtest(new myClass<>());


    }

    @Test
    public void trySplit(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);

        Spliterator<Map.Entry<String, Object>> spliterator = map.entrySet().spliterator();


        //spliterator.forEachRemaining((entity)->{
        //    System.out.println(entity.getValue());
        //});
        //
        //System.out.println("=====");

        //分离

        spliterator.trySplit().trySplit().trySplit().forEachRemaining((entity)->{
            System.out.println(entity.getValue());

        });

    }

    @Test
    public void putIfAbsent(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);

        System.out.println(map.put("3", "xxxx"));
        System.out.println(map.putIfAbsent("3", "xxxx"));

        System.out.println(map);

    }


}

class myClass<T> implements Consumer<T> {


    @Override
    public void accept(T t) {
        System.out.println(t);
    }
}

class MyKey {

    @Override
    public int hashCode() {
        return 1;
    }

}