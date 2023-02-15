package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutfinal;

/**
 * @Date: 2022/10/25/11:26
 * @Description:
 */
public class StaticMethodInterface implements Interface1,Interface2 {

    @Override
    public void method1() {
        System.out.println("StaticMethodInterface");
    }

}

interface Interface1{



    static void method(){
        System.out.println("Interface1");
    }

    default void method1(){
        System.out.println("Interface2");
    }
}

interface Interface2{

    static void method(){

    }

    default void method1(){

    }

}

class test{
    public static void main(String[] args) {
        final Interface1 interface1 = new StaticMethodInterface();
        interface1.method1();

        final Interface2 interface2 = new StaticMethodInterface();
        interface2.method1();


    }
}