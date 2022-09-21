package com.roily.booknode.javatogod._01faceobj.datatype.string;

import org.junit.Test;

/**
 * @Date: 2022/08/01/11:37
 * @Description: switch支持String
 */
public class SwitchSupString {

    @Test
    public void testInt() {
        int i = 10;
        switch (i) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(i);
        }
    }

    @Test
    public void testShort() {
        short s = 10;
        switch (s) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(s);
        }
    }

    @Test
    public void testByte() {
        byte b = 10;
        switch (b) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(b);
        }
    }

    @Test
    public void testChar() {
        char c = 'a';
        switch (c) {
            case 'a':
                System.out.println('a');
                break;
            case 'b':
                System.out.println('b');
                break;
            case 'c':
                System.out.println('c');
                break;
            default:
                System.out.println(c);
        }
    }

    @Test
    public void testString() {
        String str = "abc";
        switch (str) {
            case "abc":
                System.out.println("a");
                break;
            case "bac":
                System.out.println("b");
                break;
            case "cab":
                System.out.println("c");
                break;
            default:
                System.out.println(str);
        }
    }


}
