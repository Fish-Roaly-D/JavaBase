package com.roily.bitset;

import org.junit.Test;

import java.util.BitSet;

/**
 * @version 1.0.0
 * @Description
 * @ClassName BitSetTest.java
 * @author: RoilyFish
 * @date: 2022/5/25 1:01
 */
public class BitSetTest {


    /**
     * 计算素数
     */
    @Test
    public void test(){

        int n = 100;
        BitSet b = new BitSet(n + 1);
        int i;
        for(i = 2; i <= n; i++){
            b.set(i);
        }

        i = 2;
        while(i * i <= n){
            if(b.get(i)){
                int k = 2 * i;
                while(k <=n){
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }

        i = 0;
        while(i <= n){
            if(b.get(i)){
                System.out.println(i);
            }
            i++;
        }
    }

}
