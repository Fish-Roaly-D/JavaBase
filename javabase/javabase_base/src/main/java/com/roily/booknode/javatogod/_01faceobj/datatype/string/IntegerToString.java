package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.junit.Test;

/**
 * @Date: 2022/08/01/11:27
 * @Description:  int转String的方式
 */
public class IntegerToString {

    @Test
    public void test(){

        int i = 10;

        String str1 = i + "";

        String str2 = Integer.valueOf(i).toString();

        String str3 = String.valueOf(10);

    }


}
