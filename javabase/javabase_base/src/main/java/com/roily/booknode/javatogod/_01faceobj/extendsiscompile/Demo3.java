package com.roily.booknode.javatogod._01faceobj.extendsiscompile;

/**
 * @Date: 2022/07/29/17:07
 * @Description: 访问修饰符测试
 */
public class Demo3 {
    public String str1;
    String str2;
    private String str3;
    protected String str4;
}


class ParentDemo {
    public String str1;
    private String str2;
    protected String str3;
    String str4;
}

class SonDemo extends ParentDemo {
    void method() {
        System.out.println(str1);
        System.out.println(str3);
        System.out.println(str4);
    }
}

class ClassDemo {
    void method() {
        ParentDemo parentDemo = new ParentDemo();
        System.out.println(parentDemo.str1);
        System.out.println(parentDemo.str3);
        System.out.println(parentDemo.str4);
    }
}

interface InterfaceDemo{

    default String value(){
        return "123";
    }
}