package com.roily.queue.concurrentlinkedqueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 测试同一个实例的不同引用是否相等
 * @ClassName Testdengdengyu.java
 * @author: RoilyFish
 * @date: 2022/5/14 23:26
 */
public class Testdengdengyu {

    /**
     * 测试同一个实例的不同引用是否相等
     * 在修改后是否相等
     */
    @Test
    public void testDDY() {

        MyTestClassTestdengdengyu yyc = new MyTestClassTestdengdengyu("yyc", null);

        MyTestClassTestdengdengyu p = yyc, q = p;

        System.out.println(p == q);

        q.setAge("23");

        System.out.println(p == q);
    }

    /**
     * 两个null是否相等
     */
    @Test
    public void testNull(){

        MyTestClassTestdengdengyu t1 = null;

        MyTestClassTestdengdengyu t2 = t1;

        System.out.println(t1 == t2);


        MyTestClassTestdengdengyu t3 = null;

        MyTestClassTestdengdengyu t4 = null;

        System.out.println(t3 == t4);
    }

}

@Data
@AllArgsConstructor
class MyTestClassTestdengdengyu {

    String name;
    String age;

}