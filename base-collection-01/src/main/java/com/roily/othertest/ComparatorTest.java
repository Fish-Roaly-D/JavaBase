package com.roily.othertest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class ComparatorTest {
    /**
     * Collection接口的Sort api基本使用
     * ①元素实现Comparable接口，可自然排序
     * ②未实现Comparable接口，可自定义比较器Comparator
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<User> arrayList = new ArrayList<User>();
        arrayList.add(new User(22,"yyc"));
        arrayList.add(new User(14,"yyc"));
        arrayList.add(new User(18,"yyc"));
        arrayList.add(new User(17,"yyc"));
        arrayList.add(new User(90,"yyc"));

        System.out.println("原数组:");
        System.out.println(arrayList);

        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList)反转后:");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);

        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);

    }

    /**
     * 异或
     */
    @Test
    public void test(){
        System.out.println(2^3);
        System.out.println(2^2);
        System.out.println(3^2);
        System.out.println(5^2);
    }
}
