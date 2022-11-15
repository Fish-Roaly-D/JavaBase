package com.roily.booknode.pdai._06Exception;

import org.junit.Test;

/**
 * @classname：Demo06
 * @author: rolyfish
 * @description:
 * @date: 2022/11/3 02:03
 */
public class Demo06 {

    public void m1() {
        try {
            int i = 1 / 0;
        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public StringBuilder m2() {
        final StringBuilder sb = new StringBuilder();
        try {
            return sb.append("<tryreturn>");
        } catch (RuntimeException e) {

        } finally {
            sb.append("<finally>");
        }
        return sb;
    }

    @Test
    public void test() {
        m1();
    }

}
