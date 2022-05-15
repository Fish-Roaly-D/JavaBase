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

    @Test
    public void testDDY() {

        MyTestClassTestdengdengyu yyc = new MyTestClassTestdengdengyu("yyc", null);

        MyTestClassTestdengdengyu p = yyc, q = p;

        System.out.println(p == q);

        q.setAge("23");

        System.out.println(p == q);
    }


}

@Data
@AllArgsConstructor
class MyTestClassTestdengdengyu {

    String name;
    String age;

}