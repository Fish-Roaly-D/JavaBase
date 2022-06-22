package com.roily.usefultools.collections;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @className：CollectionUtilsTest
 * @author: rolyfish
 * CollectionUtils
 * @dte: 2022/6/22 12:04
 */
public class CollectionUtilsTest {

    /**
     * 生成10个随机数在 start到end之前的数字
     *
     * @param count
     * @param start
     * @param end
     * @return
     */
    public List<Integer> createRandomCollection(int count, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * (end - start)) + start);
        }
        return list;
    }

    /**
     * 集合判空，集合为null，或元素个数为0
     */
    @Test
    public void testCollectionIsEmpty() {
        final List<Integer> randomCollection = createRandomCollection(20, 5, 15);
        if (CollectionUtils.isEmpty(randomCollection)) {
            System.out.println("集合为空");
        } else {
            System.out.println("集合不为空");
        }
    }

    /**
     * 集合合并
     * - 获取并集
     * - 获取交集
     * - 交集的补集
     * - 差集
     */
    @Test
    public void testCollectionMerge() {
        final List<Integer> randomCollection1 = createRandomCollection(5, 0, 9);
        final List<Integer> randomCollection2 = createRandomCollection(5, 0, 9);
        System.out.println("原集合1+=》\n" + randomCollection1);
        System.out.println("原集合2+=》\n" + randomCollection2);
        //并集
        final Collection<Integer> union = org.apache.commons.collections4.CollectionUtils.union(randomCollection1, randomCollection2);
        System.out.println("并集=》\n" + union);
        //交集˚
        final Collection<Integer> intersection = org.apache.commons.collections4.CollectionUtils.intersection(randomCollection1, randomCollection2);
        System.out.println("交集=》\n" + intersection);
        //交集的补集
        final Collection<Integer> disjunction = org.apache.commons.collections4.CollectionUtils.disjunction(randomCollection1, randomCollection2);
        System.out.println("补集=》\n" + disjunction);
        //差集
        final Collection<Integer> subtract = org.apache.commons.collections4.CollectionUtils.subtract(randomCollection1, randomCollection2);
        System.out.println("差集=》\n" + subtract);

    }
}