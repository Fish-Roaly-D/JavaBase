package com.roily.booknode.pdai._04fanx.codesharing;

/**
 * @Date: 2022/10/26/10:04
 * @Description:
 */
public class FanxClass {


    /**
     * 三个
     * @param a
     * @param b
     */
    private static void add(int a, int b) {
        System.out.println("int  a + b : " + (a + b));
    }
    private static void add(double a, double b) {
        System.out.println("double  a + b : " + (a + b));
    }
    private static void add(float a, float b) {
        System.out.println("float  a + b : " + (a + b));
    }

    //声明范型方法

    private static <T extends Number> void addF(T a, T b){

        System.out.println(a.getClass()+ " a + b : " + (a.doubleValue() + b.doubleValue()));
    }

    public static void main(String[] args) {
        addF(1,2);
        addF(1.0,2.0);
        addF(1.0f,2.0f);
    }

}
