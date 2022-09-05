package com.roily.booknode.javatogod._10numsic;


import org.junit.Test;

import java.math.BigDecimal;

/**
 * @classname：TestBigDecim
 * @author: rolydish
 * @description:
 * @date: 2022/9/6 00:18
 */
public class TestBigDecimal {


    /**
     * 0。1 +  0.2 != 0.3
     */
    @Test
    public void test() {

        double d1 = 0.1d;
        double d2 = 0.2d;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1 + d2);
        System.out.println((d1 + d2) == 0.3d);

    }

    @Test
    public void test2() {
        double d1 = 0.1d;
        double d2 = 0.2d;
        double d3 = 0.3d;
        final BigDecimal bigDecimal1 = BigDecimal.valueOf(d1);
        final BigDecimal bigDecimal2 = BigDecimal.valueOf(d2);

        final BigDecimal result = bigDecimal1.add(bigDecimal2);
        System.out.println(result);
        System.out.println(result.compareTo(BigDecimal.valueOf(d3)) == 0);
    }

    /**
     * 使用compareTo进行判等
     */
    @Test
    public void test3() {

        final BigDecimal bigDecimal1 = new BigDecimal("1.0");
        final BigDecimal bigDecimal2 = new BigDecimal("1.00");

        System.out.println(bigDecimal1 == bigDecimal2);
        System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2) == 0);
    }

    /**
     * 使用compareTo进行判等
     */
    @Test
    public void test4() {
        double d1 = 0.1d;
        final BigDecimal bigDecimal = new BigDecimal(d1);

        double d2 = 0.25d;
        final BigDecimal bigDecimal2 = new BigDecimal(d2);

        final BigDecimal bigDecimal3 = new BigDecimal("0.1");
        final BigDecimal bigDecimal4 = new BigDecimal("1.01");
        System.out.println(bigDecimal);
    }

    @Test
    public void test5() {

        int i = 100;
        final BigDecimal bigDecimal = new BigDecimal(i);

    }

}
