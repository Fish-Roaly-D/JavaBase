package com.roily.stack.arraystack;

import org.junit.Test;


/**
 * @version 1.0.0
 * @Description
 * @ClassName ArrayStackTest.java
 * @author: RoilyFish
 * @date: 2022/5/21 16:45
 */
public class ArrayStackTest {


    @Test
    public void test01() {
        ArrayStack<String> aStack = new ArrayStack<>();
        //入栈
        aStack.push("a");
        aStack.push("b");
        aStack.push("c");
        //遍历方法
        aStack.foreach((element) -> {
            System.out.printf(element + ",");
        });
        System.out.println();

        //出栈
        while (!aStack.isEmpty()) {
            System.out.println(aStack.pop());
        }

    }

}
