package com.roily.booknode.javatogod._01faceobj;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @classname：OverLoading
 * @author: rolyfish
 * @description:
 * @date: 2022/7/26 22:38
 */
public class OverLoading {
    void method1(String str) {
    }

    void method1(String str, String str2) {
    }

    /**
     * 返回参数可以不同
     */
    int method1(String str, int i) {
        return 1;
    }

    /**
     * 可以修改访问修饰符
     */
    public void method1(int i, String str) {
    }
    private void method1(int i, int j) {
    }

    /**
     * 可以抛出检查异常
     */
    void method1() throws IOException {
        final FileWriter fileWriter = new FileWriter("");
    }
}

/**
 * 重载可以发生在同一个类中，也可以发生在子类和父类之间
 * 其实还是同一个类，因为子类拥有父类的所有属性的方法
 */
class Parent{
    void method1(String str){
    }
}
class Son extends Parent{
    void method1(String str, int i){
    }
}