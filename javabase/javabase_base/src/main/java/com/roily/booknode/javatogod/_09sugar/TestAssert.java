package com.roily.booknode.javatogod._09sugar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @Date: 2022/09/05/13:21
 * @Description:
 */
public class TestAssert {

    public void testAssert(int num, StringBuilder sb) {
        assert num > 0 && null != sb;
    }

    public void method(){
        int num1 = 100_0_0_000;
        //一般以千为单位
        int num2 = 10_000_000;
        float f = 10_000.0_100_100_001f;
    }

    @Test
    public void method2(){

        final ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "3"));
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println("---------------");
        //即便添加元素，当前迭代也是迭代不出来的。光标会后移
        final ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext()){
            final String next = iterator.next();
            System.out.println(next);
            if (next.equals("2")){
                iterator.add("a");
            }
        }

        final Iterator<String> iterator1 = strings.iterator();

        while (iterator1.hasNext()){
            final String next = iterator1.next();
            System.out.println(next);
            if (next.equals("2")){
                iterator1.remove();
            }
        }


    }
}
