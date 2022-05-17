package com.roily;

import org.junit.Test;

/**
 * descripte:
 * @author: RoilyFish
 * @date: 2022/2/20
 */
public class StringLearn {

    /**
     * String知识点：缓存技术  不可变性
     */
    @Test
    public void cache() {

        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);

        String str3 = new String("456");
        String str4 = new String("456");
        System.out.println(str3 == str4);

        String str5 = String.valueOf("123");
        String str6 = String.valueOf("123");
        System.out.println(str5 == str6);

        /**
         * String str1 = "abc"这行代码的含义：
         * 当str缓存池中没有'abc'这个字符串对象，创建'abc'放入字符串缓存池，并将内存地址赋予str1这个引用
         * 当str缓存池中有'abc'这个字符串对象，直接将内存地址赋予str1这个引用
         * str1 str2 指向同一块内存地址
         *
         * String str3 = new String("456") 在堆内存中创建一个新的`456`字符串对象,并将内存地址赋予str3这个引用
         * str3 str4 指向不同的内存地址
         *
         * String str5 = String.valueOf("123")等价于 String str5 = "123"
         */
    }

    @Test
    public void UnChange01() {
        String str1 = "abc";
        String str2 = str1;
        str2 += "123";
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void UnChange02() {
        String str1 = "abc";
        String str2 = str1;
        str2 = "123";
        System.out.println(str1);
        System.out.println(str2);
    }
    /**
     * String类型为引用类型，拿到他的引用按理来说修改他的值并不难
     * 以上俩例子说明并不能通过引用来修改String类型的值
     *
     * UnChange01
     *      str2 += "123";
     *      在堆内存中新建一个"abc123"字符串对象，并将内存地址赋予引用
     *      所以并不会修改str1
     * UnChange02
     *      也是同理：只不过会在string字符串缓存池中创建对象
     */

}
