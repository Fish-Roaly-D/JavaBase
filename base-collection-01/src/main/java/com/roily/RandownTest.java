package com.roily;

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
        randownT(123,15,12);
    }
    public static void randownT(Object o, int start1, int end1){

        long start = new Date().getTime();
        System.out.println(start);
        for (int i = 0; i < 1000; i++) {
            System.out.println(new Object().hashCode()  & start1);
        }
        long end = new Date().getTime();
        System.out.println("=>"+(end-start));

    }
}
