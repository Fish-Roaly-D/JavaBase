package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutfinal;

import org.junit.Test;

import java.util.Collections;

/**
 * @Date: 2022/08/02/15:46
 * @Description:
 */
public class AboutFinal {

    @Test
    public void test01() {
        final StringBuilder sb = new StringBuilder("abc");
        final int i = 10;
        sb.append("123");
        System.out.println(sb.toString());
    }
}

//final
class FinalClass {
    final void method01() {
        System.out.println("method01   父类");
    }

    final void method01(int i) {
        System.out.println("method02   父类");
    }

    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        finalClass.method01();
        finalClass.method01(1);
    }
}

class FinalClassSon extends FinalClass {
//不可以重写final方法

}

class MemberField {
    /**
     * 被static final修饰，属于类不可变。必须1、在声明的时候赋值 2、或static代码块中赋值
     */
    static final StringBuilder sb1 = new StringBuilder();

    /**
     * 被final修饰，属于实例，不可变。必须1、在声明的时候赋值 2、非static代码块中赋值 3、构造方法赋值
     */
    final StringBuilder sb2 ;
    {
        sb2 = new StringBuilder();

    }

}

interface IStaticMethod{
    static void method1() {
        Collections.emptyList();
    }
    default void method2(){

    }
}