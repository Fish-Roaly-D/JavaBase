package com.roily.booknode.javatogod._08date.time;

import org.junit.Test;

import java.time.Instant;

/**
 * @Date: 2022/09/02/17:29
 * @Description:
 */
public class TestInstant {

    @Test
    public void test1(){
        final Instant now = Instant.now();

        System.out.println(now);

        System.out.println(now.getNano());

    }

}
