package com.roily.booknode.javatogod._05fanx;

/**
 * @Date: 2022/08/26/11:30
 * @Description:
 */
public class MyClassImplX implements MyInterface<String,StringBuilder>{

    @Override
    public StringBuilder method(String s) {
        return new StringBuilder(s);

    }
}
