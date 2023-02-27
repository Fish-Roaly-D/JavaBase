package com.roily.booknode.javatogod._13jvm.symbolicreference;

/**
 * @Date: 2023/02/27/16:41
 * @Description:
 */
public class SymbolicReference {


    public void method() {
        final DemoClass demoClass = new DemoClass("value");
        demoClass.method1();
        String value = demoClass.str;
    }

    public static void main(String[] args) {
        final SymbolicReference symbolicReference = new SymbolicReference();
        symbolicReference.method();
    }

}
