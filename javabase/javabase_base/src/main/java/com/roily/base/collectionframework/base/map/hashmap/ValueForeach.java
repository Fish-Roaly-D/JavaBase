package com.roily.base.collectionframework.base.map.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description hashMap  key的遍历
 * @ClassName KeyForeach.java
 * @author: RoilyFish
 * @date: 2022/4/25 0:27
 */
public class ValueForeach {


    @Test
    public void  test3(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        Collection<Object> values = map.values();
        /**
         * stream api
         * iterable
         * for(普通增强)
         * iterable foreach
         * 迭代器
         */
        System.out.println("stream api");
        values.stream().forEach((entry)->{
            System.out.println(entry);
        });
        System.out.println("iterable foreach");
        values.forEach((entry)->{
            System.out.println(entry);
        });
        System.out.println("iterable");
        Iterator<Object> iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("for");
        for (int i = 0; i < values.toArray().length; i++) {
            //得判断是否存在冲突，没有必要
        }
        System.out.println("增强for");
        for (Object entry : values) {
            System.out.println(entry);
        }
    }

    @Test
    public void  test(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(null, null);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        Collection<Object> values = map.values();
        Spliterator<Object> spliterator1 = values.spliterator();

        while (spliterator1.tryAdvance((value)->{
            System.out.println(value);
        }));

        Spliterator<Object> spliterator2 = values.spliterator();
        spliterator2.forEachRemaining((value)->{
            System.out.println(value);
        });

    }

}
