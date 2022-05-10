package com.roily.LinkedList;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ForEachLinkedList.java
 * @author: RoilyFish
 * @date: 2022/4/12 1:00
 */
public class ForEachLinkedList {


    @Test
    public void test(){

        List<String> list = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            list.add("str"+i);
        }
        //for循环
        System.out.println("============for循环=============");
        //每次get都会从头结点遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===================================");
        System.out.println("============增强for循环=============");
        //每次get都会从头结点遍历
        for (String temp : list) {
            System.out.println(temp);
        }
        System.out.println("===================================");

        //迭代器
        System.out.println("============迭代器=============");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //System.out.println(iterator.next());
        }
        System.out.println("===================================");

        //iterator api  其实也是增强for循环
        System.out.println("============迭代器=============");

        list.forEach((temp)->{
            System.out.println(temp);
        });
        System.out.println("===================================");

        //stream foreach
        System.out.println("============迭代器=============");

        list.stream().forEach((temp)->{
            System.out.println(temp);
        });
        System.out.println("===================================");

    }


}
