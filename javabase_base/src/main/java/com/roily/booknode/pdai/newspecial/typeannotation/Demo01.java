package com.roily.booknode.pdai.newspecial.typeannotation;

import org.springframework.lang.NonNull;

/**
 * @classname：Demo01
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/6 21:22
 */
public class Demo01 {

    public void test() {

        m1(null);

    }


    public void m1(@NonNull String str) {

        System.out.println(str);
    }

}
