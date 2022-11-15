package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

/**
 * @Date: 2022/10/28/16:29
 * @Description:
 */
public class Demo08 {

    static <T> T newInstance(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        final String s = Demo08.newInstance(String.class);

        // 为何定义一个方法？
        final String s1 = String.class.newInstance();

    }
}
