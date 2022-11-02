package com.roily.booknode.pdai._06Exception;

/**
 * @Date: 2022/11/02/13:17
 * @Description:
 */
public class Demo03 {


    static void m1() {
        try {
            int i = 1 / 0;

        } catch (ArithmeticException e) {
            throw e;
        }
    }

    static void m2() {
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.initCause(e);
            throw runtimeException;
        }
    }

    public static void main(String[] args) {

        // m1();

        m2();
    }


}
