package com.roily.booknode.javatogod._09sugar;

/**
 * @Date: 2022/09/05/13:09
 * @Description:
 */
public class TestCompail {

    public void method1() {
        //包装类型需要转换所以无论如何都会编译
        final Boolean flag1 = false;
        if (flag1) {
            System.out.println("flag1");
        }else {
            System.out.println("flag1   xxxx");
        }

        //基本数据类型，无需转化，编译期间就知道对应值，会舍弃其中一个分支
        final boolean flag2 = true;
        if (flag2) {
            System.out.println("flag2");
        }else {
            System.out.println("flag2   XXX");
        }

        //flag3为false  编译器会舍弃这个分之
        final boolean flag3 = false;
        if (flag3) {
            System.out.println("flag3");
        }else {
            System.out.println("flag3  xxx");
        }

    }
}
