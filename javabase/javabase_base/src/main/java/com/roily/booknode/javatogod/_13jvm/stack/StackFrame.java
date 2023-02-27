package com.roily.booknode.javatogod._13jvm.stack;

/**
 * @Date: 2023/02/27/13:39
 * @Description:
 */
public class StackFrame {

    public void method1(){
        method2();
    }

    public void method2(){
        method3();
    }

    public void method3(){
    }

    public static void main(String[] args) {

        final StackFrame stackFrame = new StackFrame();
        stackFrame.method1();

    }

}
