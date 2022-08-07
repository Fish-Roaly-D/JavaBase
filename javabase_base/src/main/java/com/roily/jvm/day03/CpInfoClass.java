package com.roily.jvm.day03;

/**
 * @classname：CpInfoIntAndFloat
 * @author: rolyfish
 * @description: int 和 float 常量池
 * @date: 2022/8/7 13:45
 */
public class CpInfoClass {
    /**
     * new关键字,真正使用到了该类。编译器会将对应的Class_info存入class常量池
     */
    StringBuilder sb = new StringBuilder();
    /**
     * 只是单纯声明,并没有真正使用到了该类。编译器不会会将对应的Class_info存入class常量池
     */
    StringBuffer sb2;

}