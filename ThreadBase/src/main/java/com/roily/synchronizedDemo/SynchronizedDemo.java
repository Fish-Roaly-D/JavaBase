package com.roily.synchronizedDemo;

import org.junit.Test;

public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {

        }

        method();
    }

    private static void method() {

    }

    @Test
    public void tt() {

        Integer i1 = 10;
        System.out.println(System.identityHashCode(i1));
        i1 = i1 + 1;
        System.out.println(System.identityHashCode(i1));
        for (int i = 0; i < 1000; i++) {
            i1++;
        }
        System.out.println(System.identityHashCode(i1));
    }

    @Test
    public void tt2() {

        Integer i1 = 10;
        Integer i2 = 20;

        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));

        i1 = i1 + 5;
        i2 = i2 - 5;

        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));

    }

    @Test
    public void tt3() {

        Integer i1 = 10;
        Integer i2 = 20;

        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));

        i1 = i1 + 5;
        i2 = i2 - 5;

        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
    }

    @Test
    public void tt5() {

        Integer i1 = 2000;
        Integer i2 = 1000;

        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));

        i1 = i1 + 500;
        i2 = i2 - 500;

        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
    }

    @Test
    public void tt4() {

        TestBean t1 = new TestBean();
        TestBean t2 = new TestBean();

        System.out.println(System.identityHashCode(t1));
        System.out.println(System.identityHashCode(t2));

        t1.add();
        t2.add();

        System.out.println(System.identityHashCode(t1));
        System.out.println(System.identityHashCode(t2));
    }

    @Test
    public void tt6() {

        String str1 = "abc";
        String str2 = "bcd";

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        str1 = str1.substring(1,3);
        System.out.println(str1);
        str2 = str2.substring(0,2);
        System.out.println(str2);

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }

}

class TestBean {

    private Integer i = 0;

    public Integer getI() {
        return i;
    }

    public void add() {
        this.i = i + 1;
    }
}