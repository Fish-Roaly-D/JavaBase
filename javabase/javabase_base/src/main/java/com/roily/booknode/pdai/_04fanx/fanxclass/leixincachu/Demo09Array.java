package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/10/28/16:36
 * @Description:
 */
public class Demo09Array {


    public static void main(String[] args) {

        Demo[] demos1 = new Demo[10];
        Demo[] demos2 = new Demo<?>[10];

        //可以但需要强转
        Demo<String>[] demos3 = (Demo<String>[]) new Demo<?>[10];

        // 编译错误
        // Demo<String>[] demos4 = new Demo<String>[10];

        // final List<String>[] lists = new List<String>[10];
    }

}

class Demo<T> {

}