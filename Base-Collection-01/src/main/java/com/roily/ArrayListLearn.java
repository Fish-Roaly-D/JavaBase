package com.roily;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class ArrayListLearn {

    @Test
    public void testSize() {

        ArrayList<Object> list = new ArrayList<Object>(10);
        System.out.println(list.size());
        //size是arrayList数组elementData中元素的个数，并不是数组定义长度
    }

    @Test
    public void testGrow() throws NoSuchFieldException {

        ArrayList<Object> list = new ArrayList<Object>();
        Field elementData1 = list.getClass().getDeclaredField("elementData");
        System.out.println(VM.current().addressOf(elementData1));

        list.add("a");
        Field elementData2 = list.getClass().getDeclaredField("elementData");
        System.out.println(VM.current().addressOf(elementData2));

        list.add("b");
        Field elementData21 = list.getClass().getDeclaredField("elementData");
        System.out.println(VM.current().addressOf(elementData21));

        for (int i = 0; i < 15; i++) {
            list.add("a");
        }
        Field elementData3 = list.getClass().getDeclaredField("elementData");
        System.out.println(VM.current().addressOf(elementData3));
    }

    @Test
    public void test(){

        System.out.println(get());
    }

    public Object get(){

        String str = "123";

        try {
            return str;
        }finally {
            str = "abc";
        }
    }

}
