package com.roily.usefultools.httpstatus;

import org.junit.Test;
import org.springframework.http.HttpStatus;

/**
 * @className：HttpStatusTest
 * @author: rolyfish
 * @description: HttpStatusTest
 * @dte: 2022/6/24 02:30
 */
public class HttpStatusTest {


    @Test
    public void httpStatusTest() {
        final HttpStatus httpStatus = HttpStatus.valueOf(404);
        System.out.println(httpStatus);
        HttpStatus httpStatus2 = HttpStatus.valueOf(500);
        System.out.println(httpStatus2);
    }

}
