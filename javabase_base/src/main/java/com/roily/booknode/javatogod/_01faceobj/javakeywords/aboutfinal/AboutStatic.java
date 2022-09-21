package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutfinal;

/**
 * @Date: 2022/08/02/16:35
 * @Description:
 */
public class AboutStatic {

    static int a;

    static {
        a = 1;
        System.out.println("静态代码块执行");
    }

    {
        System.out.println("非静态代码块执行");
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new AboutStatic();
        }
    }
}
