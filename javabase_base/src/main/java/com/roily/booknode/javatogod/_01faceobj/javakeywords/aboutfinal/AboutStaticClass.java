package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutfinal;

import com.google.errorprone.annotations.Var;

/**
 * @Date: 2022/08/02/16:50
 * @Description:
 */
public class AboutStaticClass {

    static class StaticClass {
        int a;
        static int b;
    }

    class InnerClass {
        int a;
        //不可以定义静态变量
        //static int b;
    }
    void method() {
        AboutStaticClass.InnerClass innerClass = new AboutStaticClass.InnerClass();
    }

    IInterface ia = new IInterface() {
        @Override
        public void method() {
        }
    };
}

class TestClass {
    public static void main(String[] args) {
        AboutStaticClass.StaticClass staticClass = new AboutStaticClass.StaticClass();
        System.out.println(AboutStaticClass.StaticClass.b);
    }
}

@FunctionalInterface
interface IInterface{
    void method();
}