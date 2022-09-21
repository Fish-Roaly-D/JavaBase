package com.roily.classloader.cinit;

/**
 * @classname：Code2
 * @author: rolyfish
 * @description:
 * @date: 2022/7/26 01:06
 */
public class Code2 {


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.roily.classloader.cinit.Code1",false,ClassLoader.getSystemClassLoader() );
    }


}
