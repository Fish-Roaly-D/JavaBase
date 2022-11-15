package com.roily.booknode.pdai._05annotation.TargetType;

import org.jetbrains.annotations.Unmodifiable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date: 2022/11/01/10:32
 * @Description:
 */
public class Test01 {

    void method1(@TargetType01 String str) {

        @TargetType01 String str2 = "";

        java.util. @TargetType01 Scanner console = new java.util.@TargetType01 Scanner(System.in);

        final String s = new @TargetType01 String("");
    }

    <@TargetType02 T> void method2(T t) {

    }

    <@TargetType02 T extends Comparable> void method3(T c) {

    }

    <@TargetType01 T> void method4(T t) {

    }

    <@TargetType01 T extends Comparable> void method5(T c) {

    }

    public static void main(String[] args) {

        final @UnmodifiableView List<Object> list = Collections.emptyList();
        list.add(1);
        final int abc = Integer.parseInt("abc");

    }
}
