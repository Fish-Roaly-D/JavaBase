package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import java.util.Date;

/**
 * @Date: 2022/10/28/15:06
 * @Description:
 */
public class Demo07 {
    public static void main(String[] args) {
        //ok
        final Parent<Date> son1 = new Son();
        son1.method(new Date());

        //桥接方法进行类型强转，ClassCastException
        final Parent son2 = new Son();
        son2.method(" ");

        // 编译报错
        // final Parent<String> son3 = new Son();
    }
}

class Parent<T> {
    void method(T t) {

    }
}

class Son extends Parent<Date> {
    @Override
    void method(Date date) {
        super.method(date);
    }
}

interface IPerson<T> {
    void method(T t);
}

class CPerson implements IPerson<String> {
    @Override
    public void method(String s) {
    }
}