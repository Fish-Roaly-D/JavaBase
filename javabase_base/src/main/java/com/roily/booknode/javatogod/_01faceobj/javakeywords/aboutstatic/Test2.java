package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutstatic;


import static com.roily.booknode.javatogod._01faceobj.javakeywords.aboutstatic.StaticClass1.method;
import static com.roily.booknode.javatogod._01faceobj.javakeywords.aboutstatic.StaticClass1.str;

/**
 * @Date: 2022/10/25/17:14
 * @Description:
 */
public class Test2 {


    //引用静态变量，方法
    void method2(){
        final String str2 = str;
        method();
    }

}
