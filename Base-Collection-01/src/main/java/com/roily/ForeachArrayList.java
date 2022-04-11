package com.roily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ForeachArrayList.java
 * @author: RoilyFish
 * @date: 2022/4/11 23:32
 */
public class ForeachArrayList {

    @Test
    public void test() {

        List<String> list = new ArrayList<String>();

        //添加10个元素
        for (int i = 1; i <= 5; i++) {
            list.add("str" + i);
        }

        //for循环
        System.out.println("============普通for循环=============");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===================================");

        System.out.println("============增强for循环=============");
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

        //iterator接口
        System.out.println("============iterator接口=============");

        //list.forEach(System.out::println);


        list.forEach((temp)->{
            System.out.println(temp);
        });


        System.out.println("===================================");

        //Stream  Api
        System.out.println("============Stream  Api=============");

        list.stream().forEach(System.out::println);

        System.out.println("===================================");

    }

}
