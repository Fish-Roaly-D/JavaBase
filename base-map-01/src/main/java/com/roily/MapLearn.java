package com.roily;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class MapLearn {


    //for循环break，结束循环
    @Test
    public void forBreak() {
        for (int i = 0; i < 100; i++) {
            if (i >= 20) {
                System.out.println(i);
                break;
            }
        }
    }

    //for循环break，结束循环,带label。结束内部循环，继续外循环
    @Test
    public void forBreak2() {
        xxx:
        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {
                if (j >= 20) {
                    System.out.print(j + ",");
                    break xxx;
                }
            }
            System.out.println();
        }
    }

    /**
     * hashMap的tableSizeFor方法，使用Math工具类实现
     */
    @Test
    public void tableSizeForTest() {
        int i = tableSizeForTest(33);
        System.out.println(i);
    }

    //HashMap的tableSizeof方法理解
    public static int tableSizeForTest(int n) {
        //对自然数e求对数。结合换底公式
        double m = Math.log(n) / Math.log(2);
        //没有小数返回，有小数向上进一
        int m2 = (int) Math.ceil(m);
        //2的m2幂次方
        return (int) Math.pow(2, m2);
    }
}

class Roilyfish {

    final String getValue(String str) {
        return str;
    }

    //可以被重载
    String getValue() {
        return "str";
    }

}

class Roilyfish2 extends Roilyfish {
    //不可以被重写
//    @Override
//    String getValue(String str) {
//        return super.getValue();
//    }
}