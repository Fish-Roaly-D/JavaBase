package com.roily.booknode.javatogod._01faceobj.valuepass;

/**
 * @classname：Parameters
 * @author: rolyfish
 * @description: 形式参数、实际参数
 * @date: 2022/7/30 12:21
 */
public class Parameters {

    /**
     * @param str 形参
     */
    void method(String str) {
    }

    void method2() {
        /**
         * 123  实参
         * str  实参
         */
        method("123");
        String str = "123";
        method(str);
    }

}
