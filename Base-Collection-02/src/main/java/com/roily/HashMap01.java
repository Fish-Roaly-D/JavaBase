package com.roily;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName HashMap01.java
 * @author: RoilyFish
 * @date: 2022/4/12 12:14
 */
public class HashMap01 {


    @Test
    public void NaNValue(){
        System.out.println(Double.longBitsToDouble(0x7ff8000000000000L));
        System.out.println(Float.intBitsToFloat(0x7fc00000));
    }

    @Test
    public void yihuo(){

        System.out.println(1 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 0);

    }
    @Test
    public void iftest(){

        int i  = 1;

       if (true){
           System.out.println(1);
       }
       if ((i = 2 ) > 0){
           System.out.println(2);
       }

    }

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<String,Object>();

        map.put("a",123);
        System.out.println(map.size());

        HashMap<String, Object> map1 = new HashMap<String, Object>(map);

        System.out.println(map1.size());
    }


}
