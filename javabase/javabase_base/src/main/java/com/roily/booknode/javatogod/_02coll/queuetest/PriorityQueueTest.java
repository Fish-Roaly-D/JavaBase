package com.roily.booknode.javatogod._02coll.queuetest;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Date: 2023/03/20/16:52
 * @Description:
 */
public class PriorityQueueTest {


    @Test
    public void test1() {

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((ele1,ele2)-> ele1<=ele2?1:-1);

        priorityQueue.add(10);
        priorityQueue.add(13);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(90);
        priorityQueue.add(20);
        priorityQueue.add(11);

        while (priorityQueue.size()>0) {
            System.out.println(priorityQueue.poll());

        }

    }


}
