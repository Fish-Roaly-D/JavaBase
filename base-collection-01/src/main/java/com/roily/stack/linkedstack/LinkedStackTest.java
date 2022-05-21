package com.roily.stack.linkedstack;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName LinkedStackTest.java
 * @author: RoilyFish
 * @date: 2022/5/21 18:46
 */
public class LinkedStackTest {

    @Test
    public void test(){

        LinkedStack<Object> lStack = new LinkedStack<>();

        lStack.push(1);
        lStack.push(2);
        lStack.push(3);

        lStack.foreach((element)->{
            System.out.println(element);
        });

        System.out.println("----");

        while (!lStack.isEmpty()){
            System.out.println(lStack.pop());
        }

    }



}
