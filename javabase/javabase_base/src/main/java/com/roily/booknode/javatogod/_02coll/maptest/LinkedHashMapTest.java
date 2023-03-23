package com.roily.booknode.javatogod._02coll.maptest;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Date: 2023/03/21/18:10
 * @Description:
 */
public class LinkedHashMapTest {


    @Test
    public void test1(){

        final LinkedHashMap linkedHashMap = new LinkedHashMap();

        linkedHashMap.put("a","a");

        final LinkedHashMap clone = (LinkedHashMap)linkedHashMap.clone();

        System.out.println(clone.get("a"));

    }
}
