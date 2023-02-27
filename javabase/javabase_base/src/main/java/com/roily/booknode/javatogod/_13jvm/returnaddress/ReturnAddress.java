package com.roily.booknode.javatogod._13jvm.returnaddress;

import com.roily.booknode.javatogod._13jvm.stack.StackFrame;

/**
 * @Date: 2023/02/27/17:24
 * @Description:
 */
public class ReturnAddress {

    public void method1() {
        String str1 = method2();
        StringBuilder sb = method3();
    }

    public String method2() {
        return "123";
    }

    public StringBuilder method3() {
        return new StringBuilder("123");
    }


    public static void main(String[] args) {

        final StackFrame stackFrame = new StackFrame();
        stackFrame.method1();

    }
}
