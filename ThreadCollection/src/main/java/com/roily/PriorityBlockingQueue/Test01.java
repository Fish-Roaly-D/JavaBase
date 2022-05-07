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

    @Test
    public void testContinue() {

        xxx:
        for (Integer i = 0; i < 5;i++ ) {
            System.out.println(i);
            if (i / 4 > 0)
                continue xxx;

            System.out.println("xxxx");
        }
    }

}

@Data
@Accessors(chain = true)
class MyNode {

    String var1;
}