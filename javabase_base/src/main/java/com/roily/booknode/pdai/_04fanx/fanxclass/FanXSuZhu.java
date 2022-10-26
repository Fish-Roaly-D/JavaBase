package com.roily.booknode.pdai._04fanx.fanxclass;

import lombok.Data;

import java.lang.reflect.Array;

/**
 * @Date: 2022/10/26/15:38
 * @Description:
 */
public class FanXSuZhu<T> {

    void method() {
        //ok
        final Demo[] demos1 = new Demo[10];
        //ok
        final Demo<?>[] demos2 = new Demo<?>[10];

        //错误 Generic array creation
        // final Demo<?>[] demos3 = new Demo<String>[10];

        //可以  需要强转
        final Demo<String>[] demos4 = (Demo<String>[]) new Demo<?>[10];
    }


    static <T> T[] createFunc(T... t) {
        return t;
    }

    static <T> void printFunc(T[] tArr) {

        for (int i = 0; i < tArr.length; i++) {
            System.out.print(tArr[i]);
        }
        System.out.println("    " + tArr.getClass());
    }


    void createArray() {
        final String[] strs = (String[]) Array.newInstance(String.class, 10);
    }

    static <T> T[] createArray(Class<T> type, int size) {
        return (T[]) Array.newInstance(type, 10);
    }


    public static void main(String[] args) {
        printFunc(createFunc(1, 2, 3, 4, 5, 6));

        printFunc(createFunc("a", "b", "c", "d", "e", "f"));


        final String[] array = createArray(String.class, 10);
    }


}

@Data
class Demo<T> {

    T t;
}