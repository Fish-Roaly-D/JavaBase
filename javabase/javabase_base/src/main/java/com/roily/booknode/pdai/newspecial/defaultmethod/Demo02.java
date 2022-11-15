package com.roily.booknode.pdai.newspecial.defaultmethod;

/**
 * @classname：Demo02
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/6 20:52
 */
public class Demo02 {
}


interface ICaseA1 {
    default void m() {
        System.out.println("ICaseA1");
    }
}

interface ICaseA2 {
    default void m() {
        System.out.println("ICaseA2");
    }
}

//编译报错
//class ICaseImpA1 implements ICaseA1, ICaseA2 {
//    public static void main(String[] args) {
//
//    }
//}

class ICaseImpA2 implements ICaseA1, ICaseA2 {
    @Override
    public void m() {
        //ICaseA1.super代表 接口 ICaseA1
        ICaseA1.super.m();
    }
}


interface ICaseB1 {
    default void m() {
        System.out.println("ICaseB1");
    }
}

interface ICaseB2 {
    default void m() {
        System.out.println("ICaseB2");
    }
}

interface ICaseB3 extends ICaseB1 {
    @Override
    default void m() {
        System.out.println("ICaseB3");
    }
}

class ICaseImpB1 implements /* 可有可无，B3继承了B1和B2所有抽象接口，ICaseB1, ICaseB2,*/ ICaseB3 {

    public static void main(String[] args) {
        final ICaseImpB1 iCaseImpB1 = new ICaseImpB1();
        iCaseImpB1.m();
    }
}


interface ICaseC1 {
    default void m() {
        System.out.println("ICaseC1");
    }
}

interface ICaseC2 extends ICaseC1 {
    @Override
    default void m() {
        ICaseC1.super.m();
    }
}

class ICaseImpC1 implements ICaseC1 {
    @Override
    public void m() {
        ICaseC1.super.m();
    }

     public /* 不可 static*/ void m2() {
        ICaseC1.super.m();
    }

    public static void main(String[] args) {
        final ICaseImpC1 iCaseImpC1 = new ICaseImpC1();
        iCaseImpC1.m2();
    }
}
