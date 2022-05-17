package com.roily.queue.priorityqueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName CompareTest.java
 * @author: RoilyFish
 * @date: 2022/4/28 15:10
 */
//自定义一个class实现Comparable接口
@Data
@AllArgsConstructor
class Source implements Comparable<Source> {

    Integer mathSource;
    Integer engSource;
    Integer chiSource;

    //计算平均分
    Integer calculate() {
        return (Integer) (mathSource + engSource + chiSource) / 3;
    }

    @Override
    public int compareTo(Source s) {

        return compare(this, s);
    }

    //自定义比较方法
    public static int compare(Source s1, Source s2) {
        if (s1.calculate() > s2.calculate()) {
            return 1;
        }
        if (s1.calculate() == s2.calculate()) {
            return 0;
        }
        return -1;
    }
}

public class CompareTest {

    /**
     * Comparable接口和Comparator接口。
     * 这两个接口都是函数式接口
     * ①Comparable没有@FunctionalInterface注解
     * ②Comparator被@FunctionalInterface注释
     * ③Comparator存在两个抽象方法为何还是函数式接口：equal方法是object这个超类的
     * ④基本数据类型以及String类型都是`可比较的`，实现了Comparable接口
     */

    @Test
    public void comparableTest() {
        //一般来说 -1小于 0 等于 1大于
        Comparable<StringBuffer> comparable = (sb) -> {
            if (this.hashCode() > sb.hashCode())
                return 1;
            if (this.hashCode() == sb.hashCode())
                return 0;
            else
                return -1;
        };
        System.out.println(comparable.compareTo(new StringBuffer("123")));
    }

    //基本数据类型的包装类型以及String类型都是可比较的
    @Test
    public void testIntegerComparable() {

        Integer i = 10;
        //1  代表  大于
        System.out.println(i.compareTo(5));
        //0   代表  等于
        System.out.println(i.compareTo(10));
        //-1   代表  小于
        System.out.println(i.compareTo(15));

        String str = "b";
        //1  代表  大于
        System.out.println(str.compareTo("a"));
        //0   代表  等于
        System.out.println(str.compareTo("b"));
        //-1   代表  小于
        System.out.println(str.compareTo("c"));
    }


    /**
     * 我们一般自己实现Comparable接口去定义比较规则
     */
    @Test
    public void testXX() {

        Source s1 = new Source(10, 10, 10);
        Source s2 = new Source(10, 10, 10);
        Source s3 = new Source(20, 10, 10);
        Source s4 = new Source(9, 10, 10);
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
    }


    /**
     * Comparator接口
     */
    @Test
    public void test() {

        Comparator comparator = (t1, t2) -> {
            if ((Integer) t1 > (Integer) t2)
                return 1;
            if ((Integer) t1 == (Integer) t2)
                return 0;
            return -1;
        };

        System.out.println(comparator.compare(1, 2));
    }
}

/**
 * 函数式接口：有且只有一个抽象方法的接口叫做函数式接口
 */
@FunctionalInterface
interface MyInterface {

    int cxff();

    static int getX() {
        return 1;
    }

    default int getD() {
        return 0;
    }

}