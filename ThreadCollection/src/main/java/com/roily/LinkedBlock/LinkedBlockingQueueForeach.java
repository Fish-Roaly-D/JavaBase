package com.roily.LinkedBlock;

import org.junit.Test;

import java.util.Iterator;
import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName LinkedBlockingQueueForeach.java
 * @author: RoilyFish
 * @date: 2022/5/5 1:26
 */
public class LinkedBlockingQueueForeach {


    @Test
    public void foreach() throws InterruptedException {

        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();
        addRandom(queue, 15);

        Object[] objects = queue.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.printf(objects[i] + ", ");
        }
        System.out.println();

        for (Object obj : queue) {
            System.out.printf(obj + ", ");
        }
        System.out.println();


        queue.stream().forEach((obj) -> System.out.printf(obj + ", "));
        System.out.println();

        queue.forEach((obj) -> System.out.printf(obj + ", "));
        System.out.println();

        Iterator<Object> iterator = queue.iterator();
        while (iterator.hasNext()) System.out.printf(iterator.next() + ", ");
        System.out.println();


        //while (queue.size() > 0) System.out.printf(queue.take() + ", ");
        System.out.println();

        Object obj = null;
        //while (queue.size() > 0) System.out.printf(queue.poll() + ", ");
        //while ((obj = queue.poll()) != null) System.out.printf(obj + ", ");
        System.out.println();


        Spliterator<Object> spliterator = queue.spliterator();
        //while (spliterator.tryAdvance(o -> System.out.printf(o + ", ")));
        System.out.println();

        spliterator.forEachRemaining(o -> System.out.printf(o + ", "));
        System.out.println();


    }

    public void addRandom(Queue<Object> queue, Integer capacity) {
        assert capacity > 0;
        for (Integer i = 0; i < capacity; i++) {
            queue.add((int) (Math.random() * 20));
        }
    }

    //Collection接口下的Foreach
    public void mySout(StringBuffer sb) {


    }

}
