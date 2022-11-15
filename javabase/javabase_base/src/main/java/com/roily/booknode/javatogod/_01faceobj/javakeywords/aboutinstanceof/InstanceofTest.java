package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutinstanceof;

import org.junit.Test;

/**
 * @classname：InstanceofTest
 * @author: rolyfish
 * @description:
 * @date: 2022/8/1 23:59
 */
public class InstanceofTest {

    @Test
    public void test() {

        System.out.println(InstanceofTest.class instanceof Object);
        System.out.println("InstanceofTest.class" instanceof String);
        System.out.println(Integer.valueOf(10) instanceof Integer);

        Object o = Integer.valueOf(10);
        System.out.println(o instanceof String);
    }


}
