package com.roily.hashMapForeach;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName HashMapForeach.java
 * @author: RoilyFish
 * @date: 2022/4/25 0:31
 */
public class HashMapForeach {


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
        /**
         * 首先hashMap是Map接口下的实现，而不是collection接口下的实现
         * 也就是说对于collection适用的遍历方法对于hashMap可能并不适用。
         * 比如说
         * ①获取Stream api  对象遍历
         * ②Iterable接口的 forEach
         * ③自带的迭代器（实现迭代器接口），map接口并未继承迭代器
         * ④增强for循环
         */
        //for循环（普通、增强）
        //迭代器
        //Iterable接口的 forEach
        //Stream Api的forEach

        System.out.println("=======stream  api========");
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry);
        });
        System.out.println("=======Iterable接口的foreach========");
        map.entrySet().forEach((entry) -> {
            System.out.println(entry);
        });
        System.out.println("=======迭代器========");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======增强for循环========");
        for (Map.Entry entry : map.entrySet()) {

            System.out.println(entry);
        }
        System.out.println("=======for循环========");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        //获取map节点数组的容量方法不提供对外使用  意义不大


    }

    @Test
    public void test2(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);

        System.out.println("============map接口提供的foreach方法==============");
        map.forEach((key,value)->{
            System.out.println("key:"+key+"value:"+value);
        });

        System.out.println("============split分离器forEachRemaining==============");
        Spliterator<Map.Entry<String, Object>> spliterator = map.entrySet().spliterator();

        spliterator.forEachRemaining((entry)->{
            System.out.println(entry);
        });

        System.out.println("============split分离器forEachRemaining==============");
        Spliterator<Map.Entry<String, Object>> spliterator2 = map.entrySet().spliterator();

        while (spliterator2.tryAdvance((entry)->{
            System.out.println(entry);
        }));
    }


}
