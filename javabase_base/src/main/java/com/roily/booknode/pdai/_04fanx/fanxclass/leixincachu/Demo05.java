package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Date: 2022/10/27/15:30
 * @Description:
 */
public class Demo05 {

    /**
     * 声明此方法只接受，Comparable的派生类型。他会在编译前进行类型检查，运行期间范型被擦除
     *
     * @param t
     * @param <T>
     * @return
     */
    static <T extends Comparable> T method(T t) {
        return t;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // final Demo05 d5 = new Demo05();
        //
        // final Method method = Demo05.class.getDeclaredMethod("method",Comparable.class);
        //
        // //ok
        // System.out.println(method.invoke(d5,"abc"));
        //
        // //IllegalArgumentException
        // System.out.println(method.invoke(d5,new StringBuilder()));


        /**
         * 共享字节码
         */
        final ArrayList<String> strings = new ArrayList<>();
        final ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass() == integers.getClass());//true


        //限制只能添加String类型
        final ArrayList<String> list = new ArrayList<>();
        //ok
        list.add("abc");
        //编译通过不了
        // list.add(new Object());

        //这样就可以通过
        final Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list, 123);

        //但是，取值的时候就苦逼了.ClassCastException
        final String s = list.get(1);

    }
}
