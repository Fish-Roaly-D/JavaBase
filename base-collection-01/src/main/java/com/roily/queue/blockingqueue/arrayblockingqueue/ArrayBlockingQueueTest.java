package com.roily.queue.blockingqueue.arrayblockingqueue;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ArrayBlockingQueueTest.java
 * @author: RoilyFish
 * @date: 2022/5/12 23:33
 */
public class ArrayBlockingQueueTest {

    /**
     * 测试数组内的元素内存地址是否连续
     */
    @Test
    public void testArray() {
        String[] elements = new String[]{"1", "2", "3", "4", "5"};
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            System.out.println(VM.current().addressOf(element));
        }

        /**
         * 是连续的：
         * 3588206624
         * 3588206640
         * 3588206656
         * 3588206672
         * 3588206688
         */
    }


    /**
     * 测试数组内存地址有序性规则。按添加顺序有序。
     * 0，1，2，3   内存地址值依次递增
     * 4.5.6.0.1.2.3 也是依次递增
     */
    @Test
    public void testArray02() {
        String[] elements = new String[10];

        int i = 5;

        while (i != 4) {
            elements[i] = "" + i;
            if (++i == elements.length)
                i = 0;
        }

        for (int i1 = 0; i1 < elements.length; i1++) {
            //System.err.println(elements[i1]);
            System.out.println(VM.current().addressOf(elements[i1]));
        }

    }

    //测试1：ArrayBlockingQueue在clear后，takeIndex 和 putIndex不会清零
    //测试失败，之前对于数组内存地址有序性理解不透彻。可以使用debug模式查看
    @Test
    public void testABQClear() throws InterruptedException {

        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);
        //添加5个元素
        for (int i = 0; i < 5; i++) {
            abq.add(i + "");
        }
        //清除掉
        abq.clear();
        //再添加8个
        for (int i = 0; i < 10; i++) {
            abq.add(i + "");
        }

        while (abq.remainingCapacity() < 10) {
            System.out.println(VM.current().addressOf(abq.peek()));
            abq.poll();
        }
    }


    /**
     * 测试ABQ offer(E e, long time).
     * 在1达到超时时间，会返回false
     */
    @Test
    public void test() throws InterruptedException {

        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        boolean offer = integers.offer(1, 1000, TimeUnit.MILLISECONDS);
        System.out.println(offer);
        while (true);
    }
}
