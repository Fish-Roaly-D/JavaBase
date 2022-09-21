package com.roily.jvm.day03;


import org.junit.Test;
import org.openjdk.jol.vm.VM;

/**
 * @classname：TestDemo
 * @author: rolyfish
 * @description: 内存连续么
 * @date: 2022/8/7 01:31
 */
public class TestDemo {

    @Test
    public  void test() {

        Integer i1 = 10;
        Integer i2 = 20;
        Integer i3 = 6;

        System.out.println(VM.current().addressOf(i1));
        System.out.println(VM.current().addressOf(i2));
        System.out.println(VM.current().addressOf(i3));
    }


}
