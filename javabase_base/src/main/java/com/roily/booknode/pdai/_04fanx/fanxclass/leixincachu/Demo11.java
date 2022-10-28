package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Date: 2022/10/28/17:23
 * @Description:
 */
public class Demo11 {

    void method1() {
        try {

        } catch (Exception e) {

            // }catch (IndexOutOfBoundsException ie){

        }
    }

    void method2() {
        try {

        } catch (IndexOutOfBoundsException ie) {
            throw ie;
        } catch (Exception e) {

        }
    }

}

class MyDefException/*<T>*/ extends Exception {


}

class XT {
    <T extends Throwable> void method(T e) throws Throwable {
        try {

        } catch (IndexOutOfBoundsException t) {
            throw e.initCause(t);
        }
        // catch (T t) {//不可捕获类型参数
        //     throw e.initCause(t);
        // }
    }

    public static <T extends Throwable> void method2(Class<T> e) throws Throwable {

        final T t1 = e.newInstance();

        try {

        } catch (IndexOutOfBoundsException t) {
        }
        // catch (T t) {//不可捕获类型参数
        //     throw e.newInstance().initCause(t);
        // }
    }

    public static <T extends IndexOutOfBoundsException> void method3(Class<T> e) throws Throwable {

        final T t1 = e.newInstance();

        try {

        }
        // catch (T t) {//不可捕获类型参数
        // }
        catch (IndexOutOfBoundsException t) {
        }

    }

    public static <T extends Throwable> void method4(Class<T> e) throws Throwable {
        try {
        } catch (IndexOutOfBoundsException t) {
            throw e.newInstance().initCause(t);
        }
    }

}

class TypeArg<T> {

    T t;

    public TypeArg(T t) {
        this.t = t;
    }

    public static void main(String[] args) {

        final TypeArg<String> stringTypeArg = new TypeArg<>("str");

        System.out.println(stringTypeArg.getClass());//TypeArg
        System.out.println(stringTypeArg.t.getClass());//class java.lang.String


        final Type genericSuperclass = stringTypeArg.getClass().getGenericSuperclass();

        final Type actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];

    }



}