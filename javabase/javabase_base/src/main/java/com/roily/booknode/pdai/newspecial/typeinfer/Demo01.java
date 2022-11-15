package com.roily.booknode.pdai.newspecial.typeinfer;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname：Demo01
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/6 22:03
 */
public class Demo01 {

    public static void main(String[] args) {

        //jdk 1.7 即以前
        final List<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.addAll(new ArrayList<>());//jdk7中报错
        //jdk 1.8，进行类型推断
        final List<String> stringsNew = new ArrayList<>();


        //通过目标参数类型，上下文推断
        final List<String> init = Demo01.init();
        //无需指定
        final List<String> init2 = Demo01.<String>init();

        //方法调用链路中推断
        m(1, Demo01.init());
        //无需指定
        m(1, Demo01.<Integer>init());

    }

    static <T> List<T> init() {
        return new ArrayList<>();
    }

    static <T> void m(T t, List<T> list) {
    }
}
