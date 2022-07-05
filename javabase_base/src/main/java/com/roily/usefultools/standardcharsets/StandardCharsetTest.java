package com.roily.usefultools.standardcharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @className：StandardCharsetTest
 * @author: rolyfish
 * @description: StandardCharsetTest
 * @dte: 2022/6/24 01:52
 */
public class StandardCharsetTest {

    @Test
    public void standardCharsetTest() throws IOException {
        //指定字符集
        IOUtils.readLines(new FileInputStream("1.xtx"), StandardCharsets.UTF_8);

        new String(new byte[]{1, 23}, StandardCharsets.UTF_8);

    }

}
