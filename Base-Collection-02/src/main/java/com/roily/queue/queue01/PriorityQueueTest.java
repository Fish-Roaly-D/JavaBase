package com.roily.queue.queue01;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName PriorityQueueTest.java
 * @author: RoilyFish
 * @date: 2022/4/28 15:10
 */
public class PriorityQueueTest {


    /**
     * Comparable接口
     * 可比较的
     * <p>
     * 以下例子的逻辑是
     * string 和 Integer 类型 返回1代表课比较
     * 其他返回0 代表不可比较
     */
    //定义一个方法
    public <T> void comparator(Comparable<T> comparable, T t) {
        System.out.println(comparable.compareTo(t));
    }

    @Test
    public void test01() {
        //Object obj = new Object();
        Object obj = "abc";
        comparator((str) -> {
            if (str instanceof String) {
                return 1;
            }
            if (str instanceof Integer) {
                return 1;
            }
            return 0;
        }, obj);
    }

    /**
     * comparator比较器
     */

    //定义方法
    public void compareable(Comparator<Integer> comparator) {

        System.out.println(comparator.compare(10, 15));

    }

    @Test
    public void test() {

        compareable((t1, t2) -> {
            if (t1 > t2)
                return 1;
            else
                return 0;
        });


    }

    @Test
    public void testCom() {


        Queue<Integer> queue = new PriorityQueue<>((t1, t2) -> {
            if (t1 >= t2) {
                return 0;
            } else
                return -1;
        });

        queue.add(11);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(8);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(7);

        queue.add(9);
        queue.add(10);
        queue.add(12);


        queue.forEach((a) ->
                System.out.println(a));

    }
}
