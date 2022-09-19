package com.roily.usefultools.collections;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @className：ListsTest
 * @author: rolyfish
 * @description: Lists由Guaua工程提供，包含很多好用的小工具，这里尝试使用Lists
 * @dte: 2022/6/22 19:35
 */
public class ListsTest {

    /**
     * Lists创建空集合
     */
    @Test
    public void createEmptyList() {
        //空的LinkedList
        LinkedList<String> linkedList = Lists.newLinkedList();
        //空的ArrayList
        ArrayList<String> arrayList = Lists.newArrayList();
        //空的copyOnWriteArrayList，arrayList的线程安全版本
        CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
    }

    /**
     * 可变长参数快速初始化集合
     * 可以是可变长参数
     * 可以是Iterable
     */
    @Test
    public void quickInitList() {
        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 3, 4, 5);
        System.out.println(arrayList);
    }

    /**
     * 笛卡尔积
     * 这是一个可变长参数
     */
    @Test
    public void cartesianProduct() {
        List<Integer> randomCollection1 = CollectionUtilsTest.createRandomCollection(3, 0, 9);
        List<Integer> randomCollection2 = CollectionUtilsTest.createRandomCollection(3, 0, 9);
        System.out.println(Lists.cartesianProduct(randomCollection1, randomCollection2));
    }


    /**
     * 分页
     * <p>
     * 将一个大集合分割成落干个小集合,只需要制定集合和拆分集合大小即可
     */
    @Test
    public void splitList() {

        List<Integer> randomCollection1 = CollectionUtilsTest.createRandomCollection(20, 0, 9);
        System.out.println(randomCollection1);
        List<List<Integer>> lists = Lists.partition(randomCollection1, 3);
        System.out.println("拆分后：");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        Collections.sort(randomCollection1);
        System.err.println(randomCollection1);
        //2 ,  5
        List<List<Integer>> listsx = Lists.partition(randomCollection1, 5);
        System.err.println(listsx.get(0));
        System.err.println(listsx.get(1));
        System.err.println(listsx.get(2));
    }

    /**
     * 以流的形式讲一个集合转化成另一个集合
     */
    @Test
    public void transForm() {
        List<Integer> randomCollection1 = CollectionUtilsTest.createRandomCollection(10, 0, 9);
        final List<Integer> transform = Lists.transform(randomCollection1, element -> --element);
        System.out.println(randomCollection1);
        System.out.println(transform);

        System.out.println("当然Collection接口也提供了");
        List<Integer> collect = randomCollection1.stream().map(element -> --element).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 将集合颠倒
     */
    @Test
    public void reverse() {
        List<Integer> randomCollection1 = CollectionUtilsTest.createRandomCollection(10, 0, 9);
        System.out.println("原集合：=》" + randomCollection1);

        List<Integer> reverse = Lists.reverse(randomCollection1);
        System.out.println("颠倒后：=》" + reverse);

    }
}
