package com.roily.synchronizedDemo;

public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }

        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }


}