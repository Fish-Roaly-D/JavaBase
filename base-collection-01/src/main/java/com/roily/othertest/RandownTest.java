package com.roily.othertest;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/25
 */
public class RandownTest {

    @Test
    public void intTest() {

        long start = new Date().getTime();
        System.out.println(start);

        for (int i = 0; i < 1000; i++) {
            System.out.println((int) (new Random().nextFloat()*21+5));
        }

        long end = new Date().getTime();
        System.out.println(end-start);

    }

    @Test
    public void randomTest() {
        randownT(123,15);
    }

    /**
     * 生成一个，小于2*n的随机数
     * @param o
     * @param start1
     */
    public static void randownT(Object o, int start1){

        long start = new Date().getTime();
        System.out.println(start);
        for (int i = 0; i < 1000; i++) {
            System.out.println("随机数：" + (new Object().hashCode()  & start1));
        }
        long end = new Date().getTime();
        System.out.println("=>"+(end-start));

    }
}
