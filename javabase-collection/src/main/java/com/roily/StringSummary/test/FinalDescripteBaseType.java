package com.roily.StringSummary.test;

/**
 * descripte: final修饰基本数据类型
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
public class FinalDescripteBaseType {

    final int i = 5;

    public static void main(String[] args) {

        FinalDescripteBaseType finalDescripteBaseType = new FinalDescripteBaseType();
        //引用数据类型  被final修饰，作为局部变量， 其值不可变
        //finalDescripteBaseType.i = 10;

    }

    public void test(){
        //基本数据类型  被final修饰，作为局部变量， 其值不可变
        final  int i = 10;
        //i = 20;
    }

}
