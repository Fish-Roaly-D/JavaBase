package com.roily.base.collectionframework.base.queue.concurrentlinkedqueue;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName ContinueAndBreak.java
 * @author: RoilyFish
 * @date: 2022/5/14 23:42
 */
public class ContinueAndBreak {

    //continue  跳出当前循环，继续执行循环
    //如果是双重循环，跳出内循环
    @Test
    public void testContinue() {

        final int x = 9;
        final int y = 9;

        for (Integer i = 0; i < x; i++) {
            Integer iTemp = i + 1;
            for (Integer j = 0; j < y; j++) {
                Integer jTemp = j + 1;
                System.out.printf(jTemp + "*" + iTemp + "=" + (jTemp * iTemp) + "\t");
                if (i == j)
                    continue;
            }
            System.out.println();
        }

    }

    //使用lable。可以跳到指定位置
    @Test
    public void testContinueLocation() {

        final int x = 9;
        final int y = 9;
        lable:
        for (Integer i = 0; i < x; i++) {
            Integer iTemp = i + 1;
            for (Integer j = 0; j < y; j++) {
                Integer jTemp = j + 1;
                System.out.printf(jTemp + "*" + iTemp + "=" + (jTemp * iTemp) + "\t");
                if (i == j) {
                    System.out.println();
                    continue lable;
                }
            }

        }
    }



    //break  完全跳出当前循环 继续执行父循环
    @Test
    public void testBreak() {

        final int x = 9;
        final int y = 9;

        for (Integer i = 0; i < x; i++) {
            Integer iTemp = i + 1;
            for (Integer j = 0; j < y; j++) {
                Integer jTemp = j + 1;
                System.out.printf(jTemp + "*" + iTemp + "=" + (jTemp * iTemp) + "\t");
                if (i == j) break;
                //break  完全跳出当前循环 继续执行父循环
            }
            System.out.println();
        }

    }
}
