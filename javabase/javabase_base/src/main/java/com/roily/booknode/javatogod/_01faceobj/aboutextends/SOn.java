package com.roily.booknode.javatogod._01faceobj.aboutextends;

/**
 * @Date: 2022/10/25/9:45
 * @Description:
 */
public class SOn extends SuperParent {


    public static void main(String[] args) {

    }

    public void staticVoid() {

        //静态成员
        final String sta = super.sta;
        super.sta();
        //静态成员
        final String psta = super.psta;
        super.psta();

        //protected 成员
        System.out.println(super.pro);
        super.pro();

        //public 成员
        System.out.println(super.pub);
        super.pub();
    }


    public SOn() {
        super();
    }
}
