package com.roily.ArrayBlock;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ArrayBlockForeach.java
 * @author: RoilyFish
 * @date: 2022/5/4 1:26
 */
public class ArrayBlockForeach {


    @Test
    public void testForeach() throws InterruptedException {

        /**
         * queue 是 collection的子接口
         */
        final StringBuffer sb = new StringBuffer();

        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(20);

        for (int i = 0; i < 20; i++) {
            queue.add(i);
        }

        System.out.println("=======增强for循环========");
        for (Object obj : queue) {
            sb.append(obj + ", ");
        }
        mySout(sb);

        System.out.println("=======Collectio stream api========");
        queue.stream().forEach((obj) -> {
            sb.append(obj + ", ");
        });
        mySout(sb);

        System.out.println("=======Iterable foreach========");
        queue.forEach((obj) -> {
            sb.append(obj + ", ");
        });
        mySout(sb);

        System.out.println("=======迭代器========");
        Iterator<Object> iterator = queue.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next() + ", ");
        }
        mySout(sb);

        System.out.println("=======toArray 转数组foreach========");
        Object[] objects = queue.toArray();
        for (int i = 0; i < objects.length; i++) {
            sb.append(objects[i] + ", ");
        }
        mySout(sb);

        //System.out.println("=======take========");
        //int size = queue.size();
        //while (size-- > 0) {
        //    sb.append(queue.take() + ", ");
        //}
        //mySout(sb);

        //System.out.println("=======poll  不会await========");
        //Object poll = null;
        //while ((poll = queue.poll()) != null) {
        //    sb.append(poll+", ");
        //}
        //mySout(sb);

        //System.out.println("=======分离器1========");
        //Spliterator<Object> spliterator = queue.spliterator();
        //while (spliterator.tryAdvance((obj) ->
        //        sb.append(obj + ", ")
        //)) ;
        //mySout(sb);

        System.out.println("=======分离器2========");
        Spliterator<Object> spliterator2 = queue.spliterator();
        spliterator2.forEachRemaining((obj) -> sb.append(obj + ", "));
        mySout(sb);
    }

    public void mySout(StringBuffer sb) {
        StringBuffer sbTemp = new StringBuffer("{");
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        sbTemp.append(sb);
        System.out.println(sbTemp.toString());
        sb.delete(0, sb.length());
    }

}
