package com.roily.aboutAbstract;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AboutAbstract.java
 * @author: RoilyFish
 * @date: 2022/4/7 0:38
 */
public class AboutAbstract {
}

interface testInterface{

    //接口中不可以有(静态)代码块
    //接口不可以被初始化且没有代码块，而final修饰的成员变量要么在代码块中初始化，要么在构造器初始化
    public final int a = 1;

    //可以定义抽象方法
    abstract public void test();

    //可以用default定义默认方法，注意这是java8的特性
    default  void testDefault(){
        System.out.println("testDefault");
    }

}

abstract class testAbstract{
    //可以定义fianl成员变量，且可以初始化也可以在代码块初始化（抽象类不可以实例化，也就是没有构造方法）
    private final int a;

    static {
        System.out.println("static 代码块");
    }
    {
        a = 1;
        System.out.println("代码块");
    }

    //可以定义具体方法
    public void testAbs(){
        System.out.println("testAbs");
    }

    //可以定义抽象方法
    abstract public void test();

}