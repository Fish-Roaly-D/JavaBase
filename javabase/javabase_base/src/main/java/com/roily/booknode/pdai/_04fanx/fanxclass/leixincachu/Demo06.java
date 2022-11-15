package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2022/10/28/11:29
 * @Description: 原始类型  & 范型类型
 */
public class Demo06 {

    /**
     * 这个范型方法，是非限定范型，编译期间类型擦除，替换为Object
     * <p>
     * 原始类型为Object
     */
    static <T> T method(T t1, T t2) {
        return t2;
    }

    static <T> List<T> method(List<T> t1, List<T> t2) {
        return t2;
    }


    public static void main(String[] args) {

        /**
         * 这里两个参数类型都会自动装箱为Integer.valueOf()
         * 返回结果是Object强转为Integer，所以范型类型为Integer
         */
        final Integer v1 = Demo06.method(1, 1);
        /**
         * 这里参数一为Integer 参数二为Double
         * 返回结果为Object需要强转为两个参数的共同最小级父类，所以范型类型为Number
         */
        final Number v2 = Demo06.method(1, 1.0);
        /**
         * 以下同理
         */
        final Serializable str = Demo06.method(1, "str");
        final Object method = Demo06.method(1, new Demo06());

        final List<? extends Serializable> method1 = Demo06.method(Collections.singletonList(1), Collections.singletonList(""));


        final Integer v3 = Demo06.<Integer>method(1, 1);
        // 报错
        // final Integer v4 = Demo06.<Integer>method(1, 1.1);
        final List<? extends Serializable> method2 = Demo06.<Integer>method(Collections.singletonList(1), Collections.singletonList(1));

    }


    public void test() {

        final List<String> list = new ArrayList<>();

        // list.add(1);
    }

    public void test1() {

        /**
         * 假设可通过编译
         * 放值没问题
         * 取值取得都是String  存的是Object 可能会ClassCastException
         */
        // final List<String> list1 = new ArrayList<Object>();

        /**
         * 假设可通过编译
         * 取值没问题，取出的Object。没意义，得强转
         * 放值没问题，只不过放的Object，后面取的时候怎么知道其类型
         */
        // final List<Object> list2 = new ArrayList<String>();

        /**
         * 以上两种写法等价于
         */
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Object());
        // List<String> listx = objects;

        ArrayList<String> strings = new ArrayList<>();
        strings.add("str");
        // List<Object> listy = strings;
        // listy.add(new Object());


    }


    public void test2() {

        /**
         *  ok  有警告
         */
        final List list1 = new ArrayList<String>();
        list1.add(1);
        list1.add("str");

        /**
         *  ok  有警告，和上面等价
         */
        final List list2 = new ArrayList();
        list2.add(1);
        list2.add("str");

        /**
         * 此刻 new ArrayList<String>();  《》中String是置灰的
         */
        final List<String> list3 = new ArrayList<String>();
        list3.add("str");
        // list3.add(1);//报错

    }

}
