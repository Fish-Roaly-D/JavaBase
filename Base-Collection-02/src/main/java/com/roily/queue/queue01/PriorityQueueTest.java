package com.roily.queue.queue01;

import lombok.AllArgsConstructor;
import lombok.Data;
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
//自定义一个class实现Comparable接口
@Data
@AllArgsConstructor
class MyClass implements Comparable<MyClass> {

    String name;
    Integer age;

    @Override
    public int compareTo(MyClass myClass) {
        int nameCompare = name.compareTo(myClass.name);
        int ageCompare = age.compareTo(myClass.age);

        //都大才大
        if (nameCompare > 0 && ageCompare == 1) {
            return 1;
        }
        //都小才小
        else if (nameCompare == -1 && ageCompare == -1) {
            return -1;
        }
        //否则都等于
        return 0;
    }
}

public class PriorityQueueTest {

    @Test
    public void testIntegerComparable() {

        //Integer i = 10;
        ////1  代表  大于
        //System.out.println(i.compareTo(5));
        ////0   代表  等于
        //System.out.println(i.compareTo(10));
        ////-1   代表  小于
        //System.out.println(i.compareTo(15));
        //
        //String str = "b";
        ////1  代表  大于
        //System.out.println(str.compareTo("a"));
        ////0   代表  等于
        //System.out.println(str.compareTo("b"));
        ////-1   代表  小于
        //System.out.println(str.compareTo("c"));

        MyClass b = new MyClass("b", 2);
        MyClass a = new MyClass("a", 1);
        System.out.println(b.compareTo(a));

    }


    @Test
    public void test() {

        Comparator comparator = (t1, t2) -> {
            if ((Integer) t1 > (Integer) t2)
                return 1;
            if ((Integer) t1 == (Integer) t2)
                return 0;
            return -1;
        };

        System.out.println(comparator.compare(1, 2));
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
        queue.add(6);

        System.out.printf("{");
        queue.forEach((a) ->
                System.out.printf(a+","));
        System.out.println("}");
        queue.remove(9);
        System.out.printf("{");

        queue.forEach((a) ->
                System.out.printf(a+","));
    }

    @Test
    public void testAdd() {
        Queue<Object> queue = new PriorityQueue<>();
        queue.add(new myClass());
        queue.add(new myClass());
    }

    @Data
    class myClass {
        String name;
    }



    @Test
    public void testGet(){

        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(11);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.printf("{");
        queue.forEach((a) ->
                System.out.printf(a+","));
        System.out.println("}");

        System.out.println(queue.element());
        System.out.println(queue.peek());

        System.out.println(queue.poll());

    }


}

@FunctionalInterface
interface MyInterface {

    int cxff();

    static int getX() {
        return 1;
    }

    default int getD() {
        return 0;
    }

}