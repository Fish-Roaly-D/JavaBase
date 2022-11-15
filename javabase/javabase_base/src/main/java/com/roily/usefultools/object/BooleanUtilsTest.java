package com.roily.usefultools.object;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

/**
 * @className：BooleanUtils
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/22 22:16
 */
public class BooleanUtilsTest {


    @Test
    public void booleanUtils() {
        Boolean b = false;
        //将int转化为boolean
        System.out.println(BooleanUtils.toBoolean(1));
        System.out.println(BooleanUtils.toBoolean(1, 1, 0));
        //将String转化为boolean
        System.out.println(BooleanUtils.toBoolean("true"));
        System.out.println(BooleanUtils.toBoolean("abc","abc","123"));

        //将boolean转化为int或integer
        System.out.println(BooleanUtils.toInteger(b, 1, 0));
        //转化为String，可以制定 "true/"false"、"off"/"on"等等
        System.out.println(BooleanUtils.toStringOnOff(b));

        //判断某个布尔值是否为true或false即便为null也没事
        System.out.println(BooleanUtils.isFalse(b));
        System.out.println(BooleanUtils.isTrue(null));
        System.out.println(BooleanUtils.isNotTrue(null));


    }
}
