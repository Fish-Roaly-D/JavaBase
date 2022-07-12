package com.roily.algorithm.useful.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @classname：GoogleBloomFilter
 * @author: rolyfish
 * @description:
 * @date: 2022/7/9 04:41
 */
public class GoogleBloomFilter {

    public static void main(String[] args) {
        /**
         * 参数说明：
         *  - 参数漏斗
         *  - 预期插入多少次
         *  - 预期误判率
         */
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 100, 0.01);

        /**
         * 将元素放入布隆过滤器
         * - 位集发生改变则一定是首次添加返回true
         * - 位集未发生改变，可能不是首次添加（存在误判），返回false
         */
        filter.put("123");

        /**
         * 判断元素是否存在于位集
         * - false 一定不存在
         * - true  可能存在（存在误判）
         */
        filter.test("123");
    }
}
