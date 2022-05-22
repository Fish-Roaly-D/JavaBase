package com.roily.map.hashtable;

import java.util.Hashtable;

/**
 * @version 1.0.0
 * @Description 测试hashTable可不可以添加  null key
 * @ClassName TestHashTableCanAddNullKey.java
 * @author: RoilyFish
 * @date: 2022/5/20 2:09
 */
public class TestHashTableCanAddNullKey {

    /**
     * 不可以添加 空的 key 和 value
     *
     * value会检测
     * key会调用hashCode()方法
     * @param args
     */

    public static void main(String[] args) {

        Hashtable<String, String> table = new Hashtable<>();

        ////报错  空指针异常
        table.put(null,"1");

        //报错  空指针异常
        table.put("zx",null);
    }


}
