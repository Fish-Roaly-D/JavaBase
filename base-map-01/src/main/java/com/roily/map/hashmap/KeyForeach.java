package com.roily.map.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description hashMap  key的遍历
 * @ClassName KeyForeach.java
 * @author: RoilyFish
 * @date: 2022/4/25 0:27
 */
public class KeyForeach {


    @Test
    public void test() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        //for循环（普通、增强）
        //迭代器
        //Iterable接口的 forEach
        //Stream Api的forEach

        Set<String> keySet = map.keySet();

        System.out.println("======stream  api======");
        keySet.stream().forEach((key) -> {
            System.out.println(key);
        });

        System.out.println("======Iterable 提供的foreach方法======");
        keySet.forEach((key) -> {
            System.out.println(key);
        });

        System.out.println("======迭代器======");
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("======for循环======");
        for (String key : keySet) {
            System.out.println(key);
        }


    }

    @Test
    public void test2() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        //for循环（普通、增强）
        //迭代器
        //Iterable接口的 forEach
        //Stream Api的forEach

        Set<String> keySet = map.keySet();

        Spliterator<String> spliterator1 = keySet.spliterator();
        System.out.println("tryAdvance");
        while (spliterator1.tryAdvance((key) -> {
            System.out.println(key);
        })) ;
        System.out.println("forEachRemaining");
        Spliterator<String> spliterator2 = keySet.spliterator();
        spliterator2.forEachRemaining((key)->{
            System.out.println(key);
        });
    }


}
