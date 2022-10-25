package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutstatic;

/**
 * @Date: 2022/10/25/17:22
 * @Description:
 */
public class Son extends Parent{

    static {
        System.out.println("Son 静态代码块");
    }

    {
        System.out.println("Son 普通代码块");
    }

    public Son() {
        System.out.println("Son 构造方法");
    }

    public static void main(String[] args) {
        final Son son = new Son();
    }
}
