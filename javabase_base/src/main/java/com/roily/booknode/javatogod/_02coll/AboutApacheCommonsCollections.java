package com.roily.booknode.javatogod._02coll;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.bag.PredicatedSortedBag;
import org.apache.commons.collections4.bag.SynchronizedBag;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.collections4.bag.TransformedBag;
import org.apache.commons.collections4.bag.TreeBag;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Date: 2022/08/18/11:33
 * @Description:
 */
public class AboutApacheCommonsCollections {


    @Test
    public void testBag() {

        /**
         * hashBag底层是一个hashMap 元素是key值，添加个数是value
         * 可以通过add(object,nCopies)方法为每个元素添加n个副本
         * 如果add两次则会跟新value值（加一）
         */
        StringBuilder sb1 = new StringBuilder("a");
        StringBuilder sb2 = new StringBuilder("b");
        StringBuilder sb3 = new StringBuilder("c");
        Bag<Object> hashBag = new HashBag<>();

        hashBag.add(sb1);
        hashBag.add(sb1);
        hashBag.add(sb2, 3);
        hashBag.add(sb3, 3);
        System.out.println("Bag+元素个数:" + hashBag.size());
        System.out.println("Bag中sb1个数:" + hashBag.getCount(sb1));
        String result1 = hashBag.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("HashBag 内容：" + result1);
        //可以使用Collection作为构造方法参数
        Bag<Object> hashBag2 = new HashBag<>(Arrays.asList("1", "2", "3"));
        String result3 = hashBag2.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("hashBag2 内容：" + result3);

        /**
         * TreeBag：底层封装了一个TreeMap。
         * 其实可依发现HashBag中的元素是无序的，那么TreeBag就是一个有序的Bag
         */
        TreeBag<Object> treeBag = new TreeBag<>(Arrays.asList("99", "2", "3", "7"));
        String result2 = treeBag.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("TreeBag 内容：" + result2);

        /**
         * CollectionBag的创建依赖于现有Bag，不可使用Collection作为构造方法参数
         *
         * 其内方法是对Bag的一层封装，实际调用的还是Bag的方法
         */
        Bag<Object> collectionBag = CollectionBag.collectionBag(hashBag);
        String result4 = collectionBag.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("CollectionBag的内容：" + result4);

        Bag<Object> collectionBag2 = CollectionBag.collectionBag(treeBag);
        String result5 = collectionBag2.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("CollectionBag2的内容：" + result5);

        /**
         * 创建PredicatedBag也依赖一个现有Bag，以及一个‘判断器’
         */
        PredicatedBag<Object> predicatedBag = PredicatedBag.predicatedBag(collectionBag, Objects::nonNull);
        String result6 = predicatedBag.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("predicatedBag的内容:" + result6);

        PredicatedBag<Object> predicatedBag2 = PredicatedSortedBag.predicatedBag(collectionBag, Objects::nonNull);
        String result7 = predicatedBag2.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("predicatedBag2的内容:" + result7);


        /**
         * SynchronizedBag同步的bag，使用Synchronized同步代码块实现同步。
         * 可以指定锁对象，如果不指定则锁this
         */
        SynchronizedBag<Object> synchronizedBag = SynchronizedBag.synchronizedBag(collectionBag);
        SynchronizedSortedBag<Object> synchronizedSortedBag = SynchronizedSortedBag.synchronizedSortedBag(treeBag);


        /**
         * TransformedBag
         */
        Bag<Object> bag1 = TransformedBag.transformingBag(hashBag, Object::hashCode);
        bag1.add("XX", 3);
        String result8 = bag1.stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("TransformedBag.transformingBag " + result8);

        Bag<Object> bag2 = TransformedBag.transformedBag(hashBag, Object::hashCode);
        bag2.add("xx", 3);
        String result9 = bag2.stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println("TransformedBag.transformingBag " + result9);

        /**
         * BagUtils  Bag工具类 协助生成Bag
         */
        final Bag<Object> bag = BagUtils.collectionBag(new HashBag<>());

    }


    /**
     * bidimap
     * - bidimap的put()方法中key-value有任意重复的此条记录会被覆盖
     */
    @Test
    public void testBidiMap() {

        final DualHashBidiMap<String, Integer> dualHashBidiMap = new DualHashBidiMap<>();
        dualHashBidiMap.put("a", 1);
        dualHashBidiMap.put("b", 2);
        dualHashBidiMap.put("c", 3);
        dualHashBidiMap.put("d", 3);
        dualHashBidiMap.put("e", 12);
        dualHashBidiMap.put("e", 123);

        System.out.println(dualHashBidiMap.get("a"));
        System.out.println(dualHashBidiMap.getKey(1));
        System.out.println(dualHashBidiMap.getKey(3));
        System.out.println(dualHashBidiMap.values());
        System.out.println(dualHashBidiMap.keySet());


        final TreeBidiMap<String, Integer> treeBidiMap = new TreeBidiMap<>();
        treeBidiMap.put("a", 1);
        treeBidiMap.put("b", 2);
        treeBidiMap.put("c", 3);
        treeBidiMap.put("d", 3);
        treeBidiMap.put("e", 12);
        treeBidiMap.put("e", 123);

        System.out.println(treeBidiMap.get("a"));
        System.out.println(treeBidiMap.getKey(1));
        System.out.println(treeBidiMap.getKey(3));
        System.out.println(treeBidiMap.values());
        System.out.println(treeBidiMap.keySet());

    }

}
