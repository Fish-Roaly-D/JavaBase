package com.roily.booknode.javatogod._02coll;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @classname：AboutClooections
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/15 22:57
 */
public class AboutCollections {


    @Test
    public void test1() {

        final StringBuffer sb1 = new StringBuffer("a");
        final StringBuffer sb2 = new StringBuffer("b");
        final StringBuffer sb3 = new StringBuffer("c");
        final StringBuffer sb4 = new StringBuffer("d");
        final StringBuffer sb5 = new StringBuffer("e");
        final StringBuffer sb6 = new StringBuffer("f");
        final List<StringBuffer> sbSource = Arrays.asList(sb1, sb2, sb3, sb4, sb5);
        final List<StringBuffer> sbTarget = Arrays.asList(sb6, sb6, sb6, sb6, sb6, sb6);
        Collections.copy(sbTarget, sbSource);
        sb1.append("|update|");

        sbTarget.forEach(System.out::print);


    }


}
