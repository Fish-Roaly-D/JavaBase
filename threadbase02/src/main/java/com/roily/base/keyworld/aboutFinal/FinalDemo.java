package com.roily.base.keyworld.aboutFinal;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName FinalDemo.java
 * @author: RoilyFish
 * @date: 2022/3/19 18:22
 */
public class FinalDemo {

    //static修饰类变量  不给初始值  为默认值null
    private static String a1;
    //static修饰类变量  给初始值  为a2
    private static String a2 = "a2";

    //final修饰类变量  必须给默认值 如果不给默认值需要在构造器初始化
    //private static final String b1;
    private static final String b2 = "b2";
    //private final String c1;
    private final String c2 = "c2";

    //实例变量  不给初始值  为默认值null
    private String d1;
    //实例变量  给初始值  为a2
    private String d2 = "d2";

    static {
        //可在静态代码块赋予初始值
        a1 = "a1";
        a2 = "a22";

    }

    {
        //static修饰类变量  可以在代码块赋值
        a1 = "a11";
        d1 = "d11";
        d1 = "d22";
        //c1= "1";

    }
    //public FinalDemo(String d1, String d2) {
    //    this.d1 = d1;
    //    this.d2 = d2;
    //}

    public void test(final String a) {
        //可显示初始化
        //final String b = "b";
        final String b;
        //后续赋值
        b = "b";
        //不可重复赋值
        //b = "b";
        //不可重复赋值
        //a = "a";

    }

    public static void main(String[] args) {

        FinalDemo finalDemo = new FinalDemo();
        finalDemo.test("x");
    }

}
