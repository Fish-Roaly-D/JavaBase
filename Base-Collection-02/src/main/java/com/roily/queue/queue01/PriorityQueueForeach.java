package com.roily.queue.queue01;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description PriorityQueue 遍历
 * @ClassName PriorityQueueForeach.java
 * @author: RoilyFish
 * @date: 2022/5/2 15:40
 */
public class PriorityQueueForeach {


    @Test
    public void testForeach() {

        Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 10; i > 0; i--) {
            queue.add(i);
        }

        System.out.println("=======遍历方法========");

        System.out.println("=======queue是Collection接口的子接口========");

        System.out.println("=======1、Collection接口stream  api 的foreach========");
        StringBuffer sb1 = new StringBuffer("[");
        queue.stream().forEach((i) -> sb1.append(i).append(","));
        sout(sb1);

        System.out.println("=======2、Collection接口toArray+size  for循环========");
        StringBuffer sb2 = new StringBuffer("[");
        Object[] objects = queue.toArray();
        for (int i = 0; i < queue.size(); i++) {
            sb2.append(objects[i]).append(",");
        }
        sout(sb2);

        System.out.println("=======3、Iterable接口的foreach========");
        StringBuffer sb3 = new StringBuffer("[");
        queue.forEach((i) -> sb3.append(i).append(","));
        sout(sb3);

        System.out.println("=======4、迭代器========");
        StringBuffer sb4 = new StringBuffer("[");
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) sb4.append(iterator.next()).append(",");
        sout(sb4);

        System.out.println("===========5、分离器tryAdvance==============");
        StringBuffer sb5 = new StringBuffer("[");
        //记得Has和Map的分离器么，这个一样的
        Spliterator<Integer> spliterator1 = queue.spliterator();
        while (spliterator1.tryAdvance((i) -> sb5.append(i).append(","))) ;
        sout(sb5);

        System.out.println("===========6、分离器forEachRemaining==============");
        StringBuffer sb6 = new StringBuffer("[");
        //记得Has和Map的分离器么，这个一样的
        Spliterator<Integer> spliterator2 = queue.spliterator();
        spliterator2.forEachRemaining((i) -> sb6.append(i).append(","));
        sout(sb6);

        System.out.println("===========7、增强for循环==============");
        StringBuffer sb7 = new StringBuffer("[");
        for (Integer i : queue) sb7.append(i).append(",");
        sout(sb7);

        //System.out.println("===========8、弹==============");
        //        //StringBuffer sb8 = new StringBuffer("[");
        //        //Integer i = null;
        //        //while ((i = queue.poll()) != null) {
        //        //    System.out.println(queue);
        //        //    sb8.append(i).append(",");
        //        //}
        //        //sout(sb8);

        System.out.println("===========9、弹==============");
        StringBuffer sb9 = new StringBuffer("[");
        Integer i2 = null;
        try {
            while ((i2 = queue.remove()) != null) {
                System.out.println(queue);
                sb9.append(i2).append(",");
            }
        } catch (Exception e) {
            sout(sb9);
            return;
        }


    }

    public void sout(StringBuffer sb1) {
        sb1.deleteCharAt(sb1.lastIndexOf(","));
        sb1.append("]");
        System.out.println(sb1.toString());
    }

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
