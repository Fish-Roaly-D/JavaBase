package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;

/**
 * @Date: 2022/08/01/12:57
 * @Description: 字符串缓存池
 */
public class StringCache {

    @Test
    public void testStrCache(){
        String str1 = "abc";
        String str2 = new String("abc");
    }

    @Test
    public void testStrCache2(){
        String str1 = "abc";
        String str2 = String.valueOf("abc");
        String str3 = "abc";

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);

    }



    @Test
    public void testStringIntern(){


        String str = "abc";

        final String intern = str.intern();

        System.out.println(VM.current().addressOf(str));
        System.out.println(VM.current().addressOf(intern));


    }


}

class demo{

    char[] value;
    int start;
    int end;

    public demo(char[] value, int start, int end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }

}