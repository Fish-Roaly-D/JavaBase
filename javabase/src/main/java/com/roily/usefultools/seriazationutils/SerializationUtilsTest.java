package com.roily.usefultools.seriazationutils;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @className：SerializationUtilsTest
 * @author: rolyfish
 * @description: SerializationUtilsTest
 * @dte: 2022/6/24 02:23
 */
public class SerializationUtilsTest {


    @Test
    public void serializationUtilsTest() {
        ArrayList<String> arrayList = Lists.newArrayList("a", "b", "c");
        System.out.println("原对象：=>" + arrayList);
        final byte[] bytes = SerializationUtils.serialize(arrayList);
        System.out.println("序列化后：=>" + Arrays.toString(bytes));
        Object result = SerializationUtils.deserialize(bytes);
        System.out.println("反序列化：=>" + result);
    }


}
