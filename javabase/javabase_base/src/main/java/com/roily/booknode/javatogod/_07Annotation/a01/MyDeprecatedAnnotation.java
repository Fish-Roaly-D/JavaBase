package com.roily.booknode.javatogod._07Annotation.a01;

/**
 * @Date: 2022/08/30/19:56
 * @Description:
 */
@Deprecated
public class MyDeprecatedAnnotation {

    @Deprecated
    public static String value = "";

    @Deprecated
    public static void method(){
    }


    public void method2(Object o){

        String str = (String) o;

    }
}
