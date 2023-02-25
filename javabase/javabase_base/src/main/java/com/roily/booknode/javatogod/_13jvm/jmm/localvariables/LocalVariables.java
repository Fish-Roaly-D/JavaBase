package com.roily.booknode.javatogod._13jvm.jmm.localvariables;

/**
 * @Date: 2023/02/23/10:27
 * @Description:
 */
public class LocalVariables {

    public static final int a = 5;
    final int b = 6;
    static int c = 7;

    public int method1(int x, int y) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = a + b;
        int hash = super.hashCode();
        return x + y;
    }

    public int foo() {


        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }

    }


}
