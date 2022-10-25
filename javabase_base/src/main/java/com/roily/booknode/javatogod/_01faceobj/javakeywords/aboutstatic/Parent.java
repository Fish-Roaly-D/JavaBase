package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutstatic;

/**
 * @Date: 2022/10/25/17:22
 * @Description:
 */
public class Parent {

    static {
        System.out.println("Parent 静态代码块");
    }

    {
        System.out.println("Parent 普通代码块");
    }

    public Parent() {
        System.out.println("Parent 构造方法");
    }
}
