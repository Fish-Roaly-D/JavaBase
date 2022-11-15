package com.roily.algorithm.useful.strcompare;

/**
 * @classname：SimpleCompare
 * @author: rolyfish
 * @description: 暴力匹配算法
 * @date: 2022/7/11 23:23
 */
public class SimpleCompare {


    /**
     * 匹配成功返回对应字符串起始下标，否则返回-1
     *
     * @param pat 模式字符串
     * @param txt 文本字符串
     * @return
     */
    private static int simpleCompare(String pat, String txt) {
        //模式字符串长度
        final int P = pat.length();
        //文本字符串长度
        final int Q = txt.length();

        //长度得够才可以包含
        for (int i = 0; i <= P - Q; i++) {
            int j;
            for (j = 0; j < Q; j++) {
                if (pat.charAt(i + j) != txt.charAt(j)) {
                    break;
                }
            }
            if (j == Q) {
                return i;
            }
        }
        //未匹配返回-1
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(simpleCompare("123321", "123"));
        System.out.println(simpleCompare("abcd", "cd"));
        System.out.println(simpleCompare("abcdab", "bc"));
        System.out.println(simpleCompare("abcdab", "x"));

    }

}
