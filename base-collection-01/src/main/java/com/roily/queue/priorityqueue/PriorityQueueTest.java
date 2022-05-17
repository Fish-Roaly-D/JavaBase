package com.roily.queue.priorityqueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @version 1.0.0
 * @Description
 * @ClassName PriorityQueueTest.java
 * @author: RoilyFish
 * @date: 2022/5/12 0:53
 */
public class PriorityQueueTest {

    /**
     * PriorityQueue是一个有序的队列，只能添加可比较的对象或自定义比较器
     */
    @Test
    public void testPriorityQueue() {
        //Integer就是一个实现了Comparable接口的类
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //没问题可以添加
        queue.add(Integer.valueOf(1));
        queue.add(Integer.valueOf(2));
    }

    /**
     * 测试PriorityQueue不可以添加为实现Comparable接口的对象
     */
    @Test
    public void testPriorityQueue2() {
        PriorityQueue<MyClass> queue = new PriorityQueue<MyClass>();
        //不可以添加，提示转换异常
        queue.add(new MyClass("1"));
        queue.add(new MyClass("2"));
    }

    @Data
    @AllArgsConstructor
    class MyClass {
        String name;
    }

    /**
     * 测试PriorityQueue添加未实现Comparable接口，但是自定义比较器的对象
     */
    @Test
    public void testXX() {

        PriorityQueue<MyClass> queue = new PriorityQueue<MyClass>((obj1, obj2) -> {
            return obj1.name.compareTo(obj2.name);
        });
        //可以添加，但一般来说用的不多
        queue.add(new MyClass("1"));
        queue.add(new MyClass("2"));
    }

    /**
     * 看一下PriorityQueue添加元素时的`有序性`体现在哪
     * <p>
     * ①最小的永远在第一个，也就是下标为0的元素
     * ②父节点parent下标为m，那么他的两个子节点下表为2m+1、2m+2都大于等于父节点
     * <p>
     * 也就是这是一个二叉堆
     */
    @Test
    public void testCom() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            Integer random = (int) (Math.random() * 20);
            queue.add(random);
            queue.forEach((obj) -> {
                System.out.printf(obj + ",");
            });
            System.out.println();
        }
    }

    /**
     * 看一下PriorityQueue移除元素时的特征
     * <p>
     * 每移除一个节点（也就是首节点、最小的节点），
     * 都会重新调整队列，使得队列保持原有有序性
     */
    @Test
    public void testGet() {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            Integer random = (int) (Math.random() * 20);
            queue.add(random);
        }
        System.out.println("==原队列==");
        queue.forEach((obj) -> {
            System.out.printf(obj + ",");
        });
        System.out.println();
        //poll()是queue接口定义的抽象方法，队列为空返回null
        while (queue.poll() != null) {
            queue.forEach((obj) -> {
                System.out.printf(obj + ",");
            });
            System.out.println();
        }
    }
}
