package com.roily.booknode.javatogod._02coll.hashsettest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Date: 2023/03/15/14:42
 * @Description:
 */
@Slf4j
public class HashSetTest {

    @Test
    public void test(){

        final HashSet<StringBuilder> hashSet = new HashSet<>(Arrays.asList(new StringBuilder("1"), new StringBuilder("2"), new StringBuilder("3")));

        final HashSet clone = (HashSet)hashSet.clone();

        // 添加元素不影响原型元素，因为这是HashSet拷贝了hashMap
        clone.add(new StringBuilder("add"));
        log.info("原型Set:{}", hashSet);
        log.info("Clone Set:{}", clone);

        final Iterator iterator = clone.iterator();
        while (iterator.hasNext()){
            final StringBuilder sb = (StringBuilder)iterator.next();
            sb.append("append");
            break;
        }
        log.info("原型Set:{}", hashSet);
        log.info("Clone Set:{}", clone);

    }

}
