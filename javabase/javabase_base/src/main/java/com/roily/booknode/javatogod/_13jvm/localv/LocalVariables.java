package com.roily.booknode.javatogod._13jvm.localv;

/**
 * @Date: 2023/02/27/15:20
 * @Description:
 */
public class LocalVariables {


    static void methodStatic() {
    }



    void methodThis() {
    }


    public int method1(int i) {
        int a = 1;
        int b = 2;
        int c = method2(a, b);
        return c;
    }




























    public int method2(int i, int j) {
        int b = i + j;
        return b;
    }



















    public void method3() {
        int a = 1;
        {
            int b = 2;
            b = a + 1;
        }
        int c = 2;
    }























    public static void main(String[] args) {
        final LocalVariables localVariables = new LocalVariables();
        localVariables.method3();
    }
}
