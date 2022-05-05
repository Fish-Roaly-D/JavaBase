package com.roily.LinkedBlockingDequeTest;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Foreach.java
 * @author: RoilyFish
 * @date: 2022/5/5 18:18
 */
public class Foreach {


    public Queue createQueue(final int capacity) {
        assert capacity > 0;
        LinkedBlockingDeque<Object> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < capacity; i++) {
            queue.add(i);
        }
        return queue;
    }

    public void mySout(StringBuffer sb) {
        StringBuffer temp = new StringBuffer("{");
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        temp.append(sb);
        System.out.println(temp);
        sb.delete(0, sb.length());
    }


    @Test
    public void test() throws InterruptedException {

        LinkedBlockingDeque<Integer> queue = (LinkedBlockingDeque) createQueue(15);
        StringBuffer sb = new StringBuffer();
        //collection 转数组 for循环
        Object[] array = queue.toArray();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + ", ");
        }
        mySout(sb);

        //collection strem foreach
        queue.stream().forEach((obj) -> sb.append(obj + ", "));
        mySout(sb);

        //iterable strem foreach
        queue.forEach((obj) -> sb.append(obj + ", "));
        mySout(sb);

        //iterator
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) sb.append(iterator.next() + ", ");
        mySout(sb);

        //remove()  会抛出异常 捕获处理一下
        while (true) {
            try {
                sb.append(queue.remove() + ", ");
            } catch (NoSuchElementException e) {
                break;
            }
        }
        mySout(sb);

        //take() 借助size
        try {
            int size = queue.size();
            while (size-- > 0)
                sb.append(queue.take() + ", ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mySout(sb);
        }

        //poll()
        Object obj = null;
        while ((obj = queue.poll()) != null) sb.append(obj + ", ");
        mySout(sb);

        //分离器1
        Spliterator<Integer> spliterator = queue.spliterator();

        //while (spliterator.tryAdvance((obj) -> sb.append(obj + ", "))) ;
        //mySout(sb);

        //分离器2
        //spliterator.forEachRemaining((obj) -> sb.append(obj + ", "));
        //mySout(sb);
    }
}
