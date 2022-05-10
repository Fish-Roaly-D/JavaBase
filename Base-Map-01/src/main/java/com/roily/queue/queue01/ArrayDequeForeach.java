package com.roily.queue.queue01;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @version 1.0.0
 * @Description ArrayDeque 遍历
 * @ClassName ArrayDequeForeach.java
 * @author: RoilyFish
 * @date: 2022/5/1 23:02
 */
public class ArrayDequeForeach {


    @Test
    public void test() {

        Deque<Object> deque = new ArrayDeque<Object>();

        //默认调用  addLast方法
        for (Integer i = 0; i < 10; i++) {
            if ((i.hashCode() & 16) == 0) {
                deque.add(i.toString());
                continue;
            }
            deque.addFirst(i);
        }


        System.out.println("===========for循环=============");
        for (Object obj : deque) {
            System.out.println(obj);
        }
        System.out.println("===========Collection接口继承Iterable接口api=============");
        deque.forEach((obj) -> {
            System.out.println(obj);
        });
        System.out.println("===========Stream  api=============");
        deque.stream().forEach((obj) -> {
            System.out.println(obj);
        });
        System.out.println("===========迭代器=============");
        Iterator<Object> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("===========转数组循环=============");
        Object[] objects = deque.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        System.out.println("===========弹栈=============");
        int size = deque.size();
        while (size-- > 0)
            System.out.println(deque.pop());


    }


}
