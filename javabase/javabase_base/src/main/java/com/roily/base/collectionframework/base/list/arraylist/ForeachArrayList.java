package com.roily.base.collectionframework.base.list.arraylist;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ForeachArrayList.java
 * @author: RoilyFish
 * @date: 2022/4/11 23:32
 */
public class ForeachArrayList {

    @Test
    public void test() {

        StringBuffer sb = new StringBuffer();
        ArrayList<Object> arrayList = addRandom(10);

        System.out.println("==转数字普通for循环==");
        Object[] array = arrayList.toArray();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + ",");
        }
        mySout(sb);

        System.out.println("==增强for循环==");
        for (Object o : arrayList) {
            sb.append(o + ",");
        }
        mySout(sb);

        System.out.println("==Collection stream api==");
        arrayList.stream().forEach(o -> sb.append(o + ","));
        mySout(sb);

        System.out.println("==Iterable foreach==");
        arrayList.forEach(o -> sb.append(o + ","));
        mySout(sb);

        System.out.println("==迭代器==");
        Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext())
            sb.append(iterator.next() + ",");
        mySout(sb);

        //System.out.println("==分离器1==");
        //Spliterator<Object> spliterator1 = arrayList.spliterator();
        //while (spliterator1.tryAdvance(o -> sb.append(o + ","))) ;
        //mySout(sb);

        //System.out.println("==分离器2==");
        //Spliterator<Object> spliterator2 = arrayList.spliterator();
        //spliterator2.forEachRemaining(o -> sb.append(o + ","));
        //mySout(sb);

    }


    public ArrayList<Object> addRandom(Integer capacity) {
        ArrayList<Object> list = new ArrayList<>(capacity);
        for (Integer i = 0; i < capacity; i++) {
            list.add(i);
        }
        return list;
    }

    public void mySout(StringBuffer sb) {

        sb.deleteCharAt(sb.lastIndexOf(","));

        System.out.println(sb);

        sb.delete(0, sb.length());

    }

}
