package com.roily.set.hashset;

import org.junit.Test;

import java.util.HashSet;

/**
 * @version 1.0.0
 * @Description
 * @ClassName HashSetTestAdd.java
 * @author: RoilyFish
 * @date: 2022/5/17 15:24
 */
public class HashSetTestAdd {

    /**
     * hashSet是基于hashMap实现的，利用了hashMap key值不重复的特性
     * <p>
     * 每个节点里的value都是 Object PRESENT = new Object();
     */
    @Test
    public void testHashSetAdd() {

        String str1 = "123";
        String str2 = "123";
        System.out.println(str1 == str2);
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add(str1));
        System.out.println(set.add(str2));
        System.out.println(set.add("abc"));
        System.out.println(set.add("456"));
        System.out.println(set.add("ABC"));
        System.out.println(set.add("....."));

        set.forEach((obj) -> {
            System.out.println(obj);
        });

    }


}
