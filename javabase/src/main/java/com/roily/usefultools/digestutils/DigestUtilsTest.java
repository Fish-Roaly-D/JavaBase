package com.roily.usefultools.digestutils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @className：DigestUtilsTest
 * @author: rolyfish
 * @description: DigestUtilsTest
 * @dte: 2022/6/24 02:09
 */
public class DigestUtilsTest {

    @Test
    public void hex() throws UnsupportedEncodingException {
        String str = "加密";
        final String strHex = DigestUtils.md5Hex(str);
        System.out.println(strHex);

        final String sha256Hex = DigestUtils.sha256Hex(str);
        System.out.println(sha256Hex);
    }



}
