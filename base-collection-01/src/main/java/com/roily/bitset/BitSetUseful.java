package com.roily.bitset;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.BitSet;
import java.util.Properties;

/**
 * @version 1.0.0
 * @Description BitSet使用
 * @ClassName BitSetUseful.java
 * @author: RoilyFish
 * @date: 2022/5/26 1:12
 */
public class BitSetUseful {


    /**
     * 计算一组数据中未出现的数
     */
    @Test
    public void testIsMissing() {

        int[] values = new int[]{1, 1, 2, 3, 3, 4, 4, 6, 9, 4, 4, 4, 5};
        BitSet bitSet = new BitSet();

        for (int value : values) {
            bitSet.set(value);
        }

        for (int i = 0; i < 10; i++)
            if (!bitSet.get(i))
                System.out.println(i);
    }

    /**
     * 计算一组数据中未出现的数,数据量大一点
     */
    @Test
    public void testIsMissingBig() throws IOException {

        String root = System.getProperty("user.dir");
        String fPath = root + "/file";
        String fName = "value.txt";
        BitSet bitSet = new BitSet();

        FileReader fileReader = new FileReader(new File(fPath, fName));

        char[] buffer = new char[1024];
        int length = 0;
        while ((length = fileReader.read(buffer)) != -1) {

            for (int i = 0; i < length; i++) {
                if (buffer[i] >= '0' && buffer[i] <= '9')
                    bitSet.set(Integer.parseInt(buffer[i] + ""));
            }
        }
        for (int i = 0; i < 10; i++)
            if (!bitSet.get(i))
                System.out.println(i);
    }


    /**
     * 对大数据排序
     */
    @Test
    public void sort() throws IOException {
        String root = System.getProperty("user.dir");
        String fPath = root + "/file";
        String fName = "value2.txt";
        BitSet bitSet = new BitSet();
        File file = new File(fPath, fName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String buffer = "";
        while (!ObjectUtils.isEmpty(buffer = br.readLine())) {
            System.out.println(buffer);
            for (int i = 0; i < buffer.length() / 4; i++) {
                bitSet.set(Integer.parseInt(buffer.substring(4 * i, 4 * i + 4)));
            }
            bitSet.set(Integer.parseInt((buffer.substring((buffer.length() / 4) * 4) + "00000").substring(0, 4)));
        }
        System.out.println(bitSet);
    }


    /**
     * 查看以恶搞对象的字节大小
     */
    @Test
    public void tesxxxt(){
        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);

        Integer integer = new Integer(1000000000);
        String integerStr = ClassLayout.parseInstance(integer).toPrintable();
        System.out.println(integerStr);
    }


    /**
     * 计算素数
     */
    @Test
    public void test() {

        int n = 100;
        BitSet b = new BitSet(n + 1);
        int i;
        for (i = 2; i <= n; i++) {
            b.set(i);
        }

        i = 2;
        while (i * i <= n) {
            if (b.get(i)) {
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }

        i = 0;
        while (i <= n) {
            if (b.get(i)) {
                System.out.println(i);
            }
            i++;
        }
    }

}
