package com.roily.algorithm.useful.kmp;

/**
 * @version 1.0.0
 * @Description KMP字符串匹配算法
 * @ClassName KmpStrCompare.java
 * @author: RoilyFish
 * @date: 2022/7/12 17:41
 */
public class KmpStrCompare {

    //求next数组


    /**
     * 如何求next数组？
     * - 0、1对应next值为 -1 0
     * - 借助最大部分匹配表
     * - 最大部分匹配表右移一位
     * next数组的含义？ : next[j] 表示 模式串[0 - j]的最大部分匹配值为next[j]
     * <p>
     * <p>
     * 模式串右移位数 = 已匹配字符串长度 - 最大模式串
     * = 当前失配下标j - next[j]
     */
    private static int[] next(int[] pat) {
        //模式串长度
        final int patLength = pat.length;
        //next[]数组
        final int[] next = new int[patLength];

        //首位为-1
        next[0] = -1;

        //前缀下标，会回滚
        int k = -1;
        //后缀下标，不会回滚
        int m = 0;

        while (k < patLength -1){

            if(k == -1 || pat[k] == pat[m]){
                k++;
                m++;
                next[m] = k;
            }else {
                //k回滚   next[k]不会超过k。
                //回滚到
                k = next[k];
            }
        }

        return next;

    }


}
