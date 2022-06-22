package com.roily.usefultools.object;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @className：StringUtilsTest
 * @author: rolyfish
 * @description: StringUtilsTest
 * @dte: 2022/6/22 22:31
 */
public class StringUtilsTest {

    /**
     * 判空
     */
    @Test
    public void isEmpty() {
        //字符串对象为null或没有字符串长度为0
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        //判断字符串是否为空行
        System.out.println(StringUtils.isBlank(" "));
    }

    /**
     * 分隔字符串
     */
    @Test
    public void split() {

        String str = "1。2。3。4。5。6。7。8。9";
        //使用String的Split当字符串对象为空时会抛出空指针异常
        System.out.println(Arrays.toString(str.split("。", 4)));

        //使用StringUtils避免空指针异常
        System.out.println(Arrays.toString(StringUtils.split(str, "。", 3)));
    }

    /**
     * 判断给定的字符串是否为纯数字
     */
    @Test
    public void testIsNumeric() {

        String str1 = "123";
        String str2 = "0.123";
        String str3 = "0.123f";
        String str4 = "123L";

        System.out.println(str1 + "=>" + StringUtils.isNumeric(str1));
        System.out.println(str2 + "=>" + StringUtils.isNumeric(str2));
        System.out.println(str3 + "=>" + StringUtils.isNumeric(str3));
        System.out.println(str4 + "=>" + StringUtils.isNumeric(str4));

    }

    /**
     * 将集合拼接成字符串，并自定义分隔符
     */
    @Test
    public void join() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        final String join = StringUtils.join(list, ",", 0, list.size());
        System.out.println(join);
    }


}
