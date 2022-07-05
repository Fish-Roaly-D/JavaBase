package com.roily.usefultools.base64utils;

import org.junit.Test;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * @className：Base64UtilsTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/24 01:35
 */
public class Base64UtilsTest {


    @Test
    public void testEncodeAndDecode() {
        String str = "abc哈哈哈";
        String strEncode = new String(Base64Utils.encode(str.getBytes(StandardCharsets.UTF_8)));
        System.out.println("加密后：=》" + strEncode);
        String strDeCode = new String(Base64Utils.decode(strEncode.getBytes(StandardCharsets.UTF_8)));
        System.out.println("解密后：=》" + strDeCode);
    }

}
