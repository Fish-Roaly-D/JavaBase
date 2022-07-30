package com.roily.booknode.javatogod._01faceobj;

import com.roily.booknode.javatogod._01faceobj.extendsiscompile.Demo3;
/**
 * @author rolyfish
 * @Date: 2022/07/29/17:12
 * @Description:  被Protected修饰的成员变量或方法，同一包下才可以访问，除非是子类
 */
public class TestDemo extends Demo3{

    void method1(){
        System.out.println(str1);
        System.out.println(str4);
    }

}
