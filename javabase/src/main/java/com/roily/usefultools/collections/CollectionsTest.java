package com.roily.usefultools.collections;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @className：Collections
 * @author: rolyfish
 * @description: Collections.class 工具类的使用
 * @dte: 2022/6/22 01:34
 */
public class CollectionsTest {

    /**
     * 生成10个随机数在 start到end之前的数字
     *
     * @param count
     * @param start
     * @param end
     * @return
     */
    public List<Integer> createRandomCollection(int count, int start, int end) {
        //检查count大于0
        Assert.check(count > 0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * (end - start)) + start);
        }
        return list;
    }


    /**
     * 使用CollectionS对List进行排序
     */
    @Test
    public void collectionsSort() {

        List<Integer> integerList = createRandomCollection(20, 5, 20);
        System.out.println("原集合：=》\n" + integerList);
        //升序
        Collections.sort(integerList);
        System.out.println("降序排序后：=》\n" + integerList);
        //可自定义比较器
        Collections.sort(integerList, (val1, val2) -> {
            if (val1 > val2) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println("自定义比较器实现升序：=》\n" + integerList);

        //将集合倒过来
        final List<Integer> randomCollection = createRandomCollection(20, 5, 20);
        System.out.println("愿集合：=》\n" + randomCollection);
        Collections.reverse(randomCollection);
        System.out.println("倒置后：=》\n" + randomCollection);
    }

    /**
     * 使用Collections获取集合的最大最小值
     */
    @Test
    public void getMaxAndMin() {

        List<Integer> integerList = createRandomCollection(20, 5, 20);
        System.out.println("集合：" + integerList);
        //最大值
        System.out.println("最大值：" + Collections.max(integerList));
        //最小值
        System.out.println("最小值：" + Collections.min(integerList));
    }

    /**
     * 将非线程安全的集合转化为线程安全的集合
     */
    @Test
    public void toConcurrentList() {

        final List<Integer> randomCollection = createRandomCollection(20, 5, 20);

        Collection<Integer> integers = Collections.synchronizedCollection(randomCollection);
    }

    /**
     * 在判空后，需要返回空集合而不是null。可以借助Collections.emptyList()方法
     */
    @Test
    public void returnEmpty() {
        final List<Object> objects = Collections.emptyList();
    }

    /**
     * 二分查找。给定集合，返回下标
     */
    @Test
    public void binarySearch() {
        final List<Integer> randomCollection = createRandomCollection(20, 5, 20);
        System.out.println(randomCollection);
        final int target = Collections.binarySearch(randomCollection, 10);
        System.out.println(target);
    }

    /**
     * 转化为不可修改集合
     */
    @Test
    public void toUnModify() {

        final List<Integer> randomCollection = createRandomCollection(20, 5, 20);
        final List<Integer> integerList = Collections.unmodifiableList(randomCollection);
        integerList.add(1);

    }
}
