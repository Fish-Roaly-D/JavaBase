package com.roily.booknode.pdai._04fanx.fanxclass;

/**
 * @Date: 2022/10/26/11:00
 * @Description:
 */
public class FanXMethod<T> {


    /**
     * 范型方法声明
     */
    private <T> void method1(T t) {
        System.out.println(t.getClass());
    }

    /**
     *
     * @param t
     * @param <T> 声明此方法为一个范型方法
     * @return 返回类型为范型
     */
    private static <T> T method2(T t) {
        System.out.println(t.getClass());
        return t;
    }

    public static void main(String[] args) {
        //范型方法使用，范型方法和所在范型类范型无关
        final FanXMethod<Integer> integerFanXMethod = new FanXMethod<>();
        integerFanXMethod.method1("123");

        FanXMethod.method2("method2");
    }
}
