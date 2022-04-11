package com.roily;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ArrayListConstractor.java
 * @author: RoilyFish
 * @date: 2022/4/11 18:58
 */
public class ArrayListConstractor {


    transient Object[] elementData;

    @Test
    public void test01(){

        String[] strColl = new String[10];

        strColl[0] = "123";

        String[] strColl2 = Arrays.copyOf(strColl, 10);

        System.out.println("strColl  地址"+strColl.hashCode()+"<==>"+"strColl[0]地址"+strColl[0].hashCode());

        System.out.println("strColl2 地址"+strColl2.hashCode()+"<==>"+"strColl2[0]地址"+strColl2[0].hashCode());

    }

    @Test
    public void test02(){
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
        //a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }



}
