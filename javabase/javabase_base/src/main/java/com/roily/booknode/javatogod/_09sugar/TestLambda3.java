package com.roily.booknode.javatogod._09sugar;

import com.google.common.base.Function;

/**
 * @Date: 2022/09/07/10:43
 * @Description:
 */
public class TestLambda3 {

    public static void main(String[] args) {

        Lambda1<TestClass> lambda1a = (testClass) -> {
            return testClass.method1("");
        };
        
        //toStringX存在重载，会自动选择无参数的方法
        Lambda1<TestClass> lambda1b = TestClass::toStringX;
        
        //有参数，不可方法声明
        // Lambda1<TestClass> lambda1c = TestClass::method1;

        final Function<String, String> stringFunction = String::toString;

        final Function<String, Integer> stringFunction1 = String::length;

    }

}

//无参
interface Lambda1<T> {
    String method(T t);
}

//无参
interface lambda2 {
    void method(String str);
}

class TestClass {

    /**
     * toString存在重载
     * 使用方法声明的时候会寻找无参数的方法
     */
    public  String toStringX(int i){
        return "i";
    }
    public String toStringX(){
        return "i";
    }

    //有参数不可使用方法声明
    public String method1(String str){
        return "i";
    }
    
}