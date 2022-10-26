package com.roily.booknode.pdai._04fanx.codesharing;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/10/26/10:13
 * @Description:
 */
public class NeedNotCask {
    public static void main(String[] args) {

        //不指定范型，也就是Object，容易CaskException
        final List objList = new ArrayList();
        objList.add(1);
        objList.add("1");
        objList.add(null);


        //new 关键字后面的<>里面不用声明类型，java会进行类型推断
        final List<Integer> integers = new ArrayList<>();
        // integers.add("1");//报错
        integers.add(1);//报错
        //不用强制转化
        final Integer integer = integers.get(0);
    }
}
