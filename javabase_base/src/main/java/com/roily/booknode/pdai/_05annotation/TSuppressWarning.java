package com.roily.booknode.pdai._05annotation;

/**
 * @Date: 2022/10/31/15:27
 * @Description:
 */
public class TSuppressWarning {

    @SuppressWarnings("all")
    public void method() {
        int i = 1 / 0;
    }

    @Deprecated
    public static void method2() {
    }

    public static void method3() {
        method2();
    }

    public static void main(String[] args) {
        method3();
    }
}

