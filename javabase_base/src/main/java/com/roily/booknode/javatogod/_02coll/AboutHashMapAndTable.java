package com.roily.booknode.javatogod._02coll;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @Date: 2022/08/16/9:52
 * @Description:
 */
public class AboutHashMapAndTable {

    /**
     * hashTable是否允许添加 null值(键、值)
     * - 不允许，会报nullPointException异常
     */
    @Test
    public void test1(){

        Hashtable<String, String> hashtable = new Hashtable<>();
        String put = hashtable.put(null, "");
    }

    /**
     * hashTable的遍历方式
     */
    @Test
    public void test2(){
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("a","1");
        hashtable.put("b","1");
        hashtable.put("c","1");
        hashtable.put("d","1");
        hashtable.put("e","1");
        //使用Enumeration
        Enumeration<String> elements = hashtable.elements();
        Enumeration<String> keys = hashtable.keys();
        //使用set
        Set<Map.Entry<String, String>> entries = hashtable.entrySet();

        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }


}
