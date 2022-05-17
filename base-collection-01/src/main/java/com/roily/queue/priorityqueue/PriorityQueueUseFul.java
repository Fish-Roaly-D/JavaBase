package com.roily.queue.priorityqueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @version 1.0.0
 * @Description PriorityQueue  可计算第k大的值
 * @ClassName PriorityQueueUseFul.java
 * @author: RoilyFish
 * @date: 2022/5/12 1:18
 */
public class PriorityQueueUseFul {

    /**
     * 如何生成随机数：Random种子，Math工具类
     */
    @Test
    public void testRandom() {
        System.out.println(new Random(System.currentTimeMillis()).nextInt(10));
        System.out.println((int) (Math.random() * 10));
    }

    //生成一个 长度为 size  范围为[small ,big]的数组
    public Integer[] random(int size, int small, int big) {
        //随机种子
        Random random = new Random(System.currentTimeMillis());

        Integer[] integers = new Integer[size];

        for (int i = 0; i < integers.length; i++) {

            integers[i] = random.nextInt(big - small) + small;
        }
        return integers;
    }

    //计算第k大的值
    @SuppressWarnings("unchecked")
    public <T> T getK(T[] pq, int k) throws MyException {
        if (pq.length < k || !(pq[0] instanceof Comparable)) {
            throw new MyException("不行");
        }
        PriorityQueue<T> tpq = new PriorityQueue<>(Arrays.asList(pq));
        T temp = null;
        while (--k >= 0){
            temp = tpq.poll();
        }
        return temp;
    }

    @Data
    @AllArgsConstructor
    class MyException extends Exception{
        String msg;
    }


    @Test
    public void test() throws MyException {
        Integer[] random = random(8, -8, 8);

        Arrays.asList(random).forEach((temp)->{
            System.out.print(temp+"  ");
        });
        System.out.println();
        System.out.println("第4大的数为："+getK(random,4));
        // -8 -6 -5 -2 2 3 5 6
    }

}
