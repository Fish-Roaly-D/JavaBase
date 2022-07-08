package com.roily.algorithm.useful.bloom;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.Calendar;

/**
 * @author rolyfish
 */
public class BloomFilter {

    /**
     * bitSet分配2^24位
     */
    private static final int DEFAULT_SIZE = 1 << 25;

    /**
     * 哈希种子，循环加权次数
     */
    private static final int[] SEEDS = new int[]{3, 5, 7, 11, 13, 31, 37, 61};
    /**
     * 位集，给定初始化范围，避免频繁扩容
     */
    private final BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * 多次哈希的哈希函数
     */
    private final SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 布隆过滤器，初始化哈希函数
     */
    public BloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 将字符串对应多次哈希结果记录到bitSet中
     */
    public void add(String value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    /**
     * 判断是否重复
     */
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
            //存在一次为0直接返回
            if (!ret) {
                break;
            }
        }
        return ret;
    }

    /**
     * 哈希函数类
     */
    @Data
    @AllArgsConstructor
    public static class SimpleHash {
        private final int cap;
        private final int seed;

        //采用简单的加权和hash
        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            //防止哈希过大
            return (cap - 1) & result;
        }
    }

    /**
     * 使用此布隆过滤器对1000万个url去重
     */
    public static void main(String[] args) {
        final long start = Calendar.getInstance().getTime().getTime();

        final BloomFilter bloomFilter = new BloomFilter();
        String filePath = "/Users/rolyfish/Desktop/MyFoot/testfile";
        String fileName = "urls.txt";
        String fileNameNew = "urlsNew.txt";
        final File fileUrl = new File(filePath, fileName);
        final File fileUtlNew = new File(filePath, fileNameNew);
        if (!fileUrl.exists()) {
            System.out.println("文件不存在");
        }
        String buffer = "";
        try (
                final FileReader fileReader = new FileReader(fileUrl);
                final BufferedReader bufferedReader = new BufferedReader(fileReader);
                final FileWriter fileWriter = new FileWriter(fileUtlNew)) {
            while ((buffer = bufferedReader.readLine()) != null) {
                if (!bloomFilter.contains(buffer)) {
                    fileWriter.write(buffer);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.flush();
                }
                //添加到布隆过滤器
                bloomFilter.add(buffer);
            }
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("io异常");
        }
        final long end = Calendar.getInstance().getTime().getTime();
        System.out.println(end - start);
    }

    /**
     * 生成1000万个url
     */
    @Test
    public void test() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/testfile";
        String fileName = "urls.txt";
        int urlNum = 10000000;
        String baseUrl = "https://www.baidu/baidu/article/details/";
        try (FileWriter fileWriter = new FileWriter(new File(filePath, fileName), true)) {
            //生成100000个url
            for (int i = 0; i < urlNum; i++) {
                //写两次
                if (i % 99 == 0) {
                    fileWriter.write(baseUrl + (urlNum + i));
                    fileWriter.write(System.lineSeparator());
                    fileWriter.flush();
                }
                fileWriter.write(baseUrl + (urlNum + i));
                fileWriter.write(System.lineSeparator());
                fileWriter.flush();
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println();
        }
    }
}