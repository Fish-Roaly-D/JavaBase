package com.roily.PriorityBlockingQueue;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Test01.java
 * @author: RoilyFish
 * @date: 2022/5/7 22:22
 */
public class Test01 {

    //测试数组的引用可以修改数组
    @Test
    public void testArray() {
        String[] str = new String[10];
        str[0] = "0";
        str[1] = "1";

        System.out.println(str[0] + " " + str[1]);
        String[] strTemp = str;
        strTemp[0] = "temp0";
        strTemp[1] = "temp1";
        System.out.println(str[0] + " " + str[1]);
    }

    //测试数组的引用可以修改数组
    @Test
    public void referCopy() {
        MyNode myNode = new MyNode();
        myNode.setVar1("myNode01");
        System.out.println(myNode.toString());

        MyNode node = myNode;

        node.setVar1("node");

        System.out.println(myNode.toString());

    }

    //continue  跳出当前循环，继续执行循环
    //如果是双重循环，跳出内循环
    @Test
    public void testContinue() {

        final int x = 9;
        final int y = 9;

        for (Integer i = 0; i < x; i++) {
            Integer iTemp = i + 1;
            xxx:
            for (Integer j = 0; j < y; j++) {
                Integer jTemp = j + 1;
                System.out.printf(jTemp + "*" + iTemp + "=" + (jTemp * iTemp) + "\t");
                if (i == j) break xxx;
                //break  跳出当前循环 继续往下执行
            }
            System.out.println();
        }

    }

    //使用lable
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

}

@Data
@Accessors(chain = true)
class MyNode {

    String var1;
}