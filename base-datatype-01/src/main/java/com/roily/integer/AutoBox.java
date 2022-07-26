package com.roily.integer;

import java.util.ArrayList;

/**
 * @Date: 2022/07/26/13:32
 * @Description: 基本数据类型的自动装箱
 */
public class AutoBox {

    /**
     * ArrayList的范型是一个Integer（int的包装类型）
     * 但是平常我们使用的时候可以直接将int放入，这就是因为
     * 基本数据类存在着自动装箱
     *
     * 使用jad反编译查看源码，发现做了自动装箱  Integer.valueOf(i)
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

    }

}
