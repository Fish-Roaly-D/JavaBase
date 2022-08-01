package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/08/01/10:40
 * @Description: String字符串拼接性能对比
 */
public class StringAppendVS {


    @Test
    public void testAppend() {
//        append1();

//        append2();
//
//        append3();

//        append4();

        append5();
    }


    /**
     * String  +
     */
    void append1() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("使用+拼接字符串");
        String str1 = "";
        for (int i = 0; i < 50000; i++) {
            str1 += "a";
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskName() + "消耗时长：" + stopWatch.getTotalTimeNanos());
    }

    /**
     * StringBuilder  append
     */
    void append2() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("使用StringBuilder拼接字符串");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            sb.append("a");
        }
        String str1 = sb.toString();
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskName() + "消耗时长：" + stopWatch.getTotalTimeNanos());
    }

    /**
     * StringBuffer  append
     */
    void append3() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("使用StringBuffer拼接字符串");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 50000; i++) {
            sb.append("a");
        }
        String str1 = sb.toString();
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskName() + "消耗时长：" + stopWatch.getTotalTimeNanos());
    }


    /**
     * String  concat
     */
    void append4() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("使用concat拼接字符串");
        String str1 = "";
        for (int i = 0; i < 50000; i++) {
            str1.concat("a");
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskName() + "消耗时长：" + stopWatch.getTotalTimeNanos());
    }

    /**
     * StringUtils  join
     */
    void append5() {
        List<String> strs = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("使用StringUtils  join拼接字符串");
        String str1 = "";
        for (int i = 0; i < 50000; i++) {
            strs.add("a");
        }

        StringUtils.join(strs);
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskName() + "消耗时长：" + stopWatch.getTotalTimeNanos());
    }

}
