package com.roily.algorithm.useful.strcompare;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @classname：KMP
 * @author: rolyfish
 * @description: todo
 * @date: 2022/7/12 01:31
 */
public class KMP {

    /**
     * 计算模式串对应next数组
     *
     * @param pat
     * @return
     */
    static int[] next(char[] pat) {
        final int pLen = pat.length;
        final int[] next = new int[pLen];
        //第一位为-1
        next[0] = -1;
        //k为 前缀下标，k会回退
        int k = -1;
        //j为后缀下标，j不回退
        int j = 0;
        while (j < pLen - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || pat[j] == pat[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 计算模式串对应next数组
     *
     * @param pat
     * @return
     */
    static int[] nextNew(char[] pat) {
        final int pLen = pat.length;
        final int[] next = new int[pLen];
        //第一位为-1
        next[0] = -1;
        //k为 前缀下标，k会回退
        int k = -1;
        //j为后缀下标，j不回退
        int j = 0;
        while (j < pLen - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || pat[j] == pat[k]) {
                //相等时,若后缀出现不匹配的情况，需要跳过前缀与文本串的比较
                if (pat[++k] == pat[++j]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int kmp(String txt, String pat) {
        final char[] t = txt.toCharArray();
        final char[] p = pat.toCharArray();
        Assert.isTrue(t.length >= p.length, "文本串不能比模式串小");
        //获取next数组
        final int[] next = next(pat.toCharArray());
        //文本串指针
        int i = 0;
        //模式串指针
        int j = 0;

        while (i < t.length && j < p.length) {
            //j = -1也就是上次循环首个字符不匹配，那么文本串都后移一位。模式串归0
            //如果匹配，模式串文本串都后移一位
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                //不匹配，模式串移动位数 = 当前下标 - 对应next值 = j - next[j]
                //模式串移动几位那么j就得回退多少 j = j - (j - next[j])
                j = next[j];
            }
        }
        //模式串比较完毕那么匹配成功
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String str = "ABDABC";
        final int[] next = next(str.toCharArray());
        System.out.println(CollectionUtils.arrayToList(next));

        System.out.println(kmp("123456", "23"));
        System.out.println(kmp("123456", "xxx"));
        System.out.println(kmp("ABCAADFCXW", "ADFC"));
    }
}
