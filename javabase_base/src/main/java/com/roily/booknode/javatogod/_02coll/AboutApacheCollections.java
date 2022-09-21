package com.roily.booknode.javatogod._02coll;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

/**
 * @classname：AboutApacheCollections
 * @author: rolyfish
 * @description: apache 提供的集合工具类
 * @date: 2022/8/17 23:20
 */
public class AboutApacheCollections {


    @Test
    public void test() {

        final Bag<Object> hashBag = new HashBag<>();

        hashBag.add(1,10);

        System.out.println(hashBag);

        final Bag<Object> collectionBag = BagUtils.collectionBag(hashBag);
        collectionBag.forEach(System.out::print);

    }



}
