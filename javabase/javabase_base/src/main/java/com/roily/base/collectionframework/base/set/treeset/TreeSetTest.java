package com.roily.base.collectionframework.base.set.treeset;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.TreeSet;

/**
 * @version 1.0.0
 * @Description
 * @ClassName TreeSetTest.java
 * @author: RoilyFish
 * @date: 2022/5/17 16:34
 */
public class TreeSetTest {

    //treeSet添加可比较的元素
    @Test
    public void testAddComparable(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1000);
        set.add(10);
        set.add(77);
        set.add(88);
        set.add(99);
        set.add(22);
        set.forEach(System.out::println);
    }

    //treeSet添加不可比较的元素
    //会报错
    @Test
    public void testAddNotComparable(){
        TreeSet<NotComparable> set = new TreeSet<>();
        set.add(new NotComparable("aa",11));
        set.add(new NotComparable("bb",22));
        set.forEach(System.out::println);
    }

    //treeSet添加不可比较的元素，自定义集合比较器
    @Test
    public void testAddNotComparableXXX(){

        System.out.println(new NotComparable("aa", 11).equals(new NotComparable("aa", 11)));
        TreeSet<NotComparable> set = new TreeSet<>((obj1,obj2)->{
            return obj1.yy.compareTo(obj2.yy);
        });
        set.add(new NotComparable("aa",11));
        set.add(new NotComparable("bb",22));
        set.add(new NotComparable("aa",1));
        set.add(new NotComparable("bb",2));
        set.add(new NotComparable("aa",6));
        set.add(new NotComparable("bb",2));
        set.add(new NotComparable("aa",11));
        set.add(new NotComparable("bb",2));
        set.forEach(System.out::println);
    }

}
@AllArgsConstructor
@Data
class NotComparable{

    String xx;
    Integer yy;

}
