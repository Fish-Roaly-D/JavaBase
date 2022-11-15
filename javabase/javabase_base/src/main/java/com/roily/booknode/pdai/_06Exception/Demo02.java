package com.roily.booknode.pdai._06Exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Date: 2022/11/02/13:02
 * @Description:
 */
public class Demo02 {

    /**
     * FileNotFoundException 是IOException的子类
     */
    static class Person {
        void m() throws FileNotFoundException {

        }

        void m2() throws IndexOutOfBoundsException {

        }
    }

    static class Son extends Person {
        /**
         * 抛出比 FileNotFoundException 则会报错 比如IOException
         *
         * @throws IOException
         */
        @Override
        void m() throws /*IOException*/ FileNotFoundException {
            super.m();
        }

        @Override
        void m2() throws RuntimeException {
            super.m2();

            int i = 1/0;
        }

    }

    public static void main(String[] args) {
        try {
            final Son son = new Son();
            son.m2();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}

