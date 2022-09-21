package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.lang.reflect.Field;

/**
 * @classname：StringType
 * @author: rolyfish
 * @description: String
 * @date: 2022/7/31 21:11
 */
public class StringType {

    /**
     * 测试String的不了变性
     */
    @Test
    public void test1() {
        String str1 = "abc";
        System.out.println(VM.current().addressOf(str1));
        str1 = "123";
        System.out.println(VM.current().addressOf(str1));
    }

    /**
     * String的缓存池技术
     */
    @Test
    public void test2() {
        String str1 = "abc";
        System.out.println(VM.current().addressOf(str1));
        String str2 = "abc";
        System.out.println(VM.current().addressOf(str2));
    }

    /**
     * 我们都知道String其内部是字符数组，且是私有的，那么我们是否可以通过反射修改其私有属性
     */
    @Test
    public void test3() throws NoSuchFieldException, IllegalAccessException {

        String str = "123";
        System.out.println(str + ":" + VM.current().addressOf(str));

        final Field value = str.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(str, "abc".toCharArray());
        System.out.println(str + ":" + VM.current().addressOf(str));


        String str2 = "123";
        System.out.println(str2 + ":" + VM.current().addressOf(str2));

        String str3 = "abc";
        System.out.println(str3 + ":" + VM.current().addressOf(str3));
    }


    @Test
    public void testFinal() throws NoSuchFieldException, IllegalAccessException {
        TestFinal testFinal = new TestFinal();
        System.out.println(testFinal.sb + ":" + VM.current().addressOf(testFinal.sb));
        final Field sb = testFinal.getClass().getDeclaredField("sb");
        final Field value = testFinal.getClass().getDeclaredField("value");
        final StringBuilder abc = new StringBuilder("abc");
        //反射破坏不可修改
        sb.setAccessible(true);
        value.setAccessible(true);
        sb.set(testFinal, abc);
        System.out.println(testFinal.sb + ":" + VM.current().addressOf(testFinal.sb));
    }

    @Test
    public void testSubstring() {

        String str = "123";

        System.out.println(str.substring(0, 2));

    }

}

class TestFinal {
    final StringBuilder sb = new StringBuilder("123");
}
