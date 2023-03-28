package com.roly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date: ${YEAR}/${MONTH}/${DAY}/${TIME}
 * @Description:
 */
@SpringBootApplication
public class OpenFeignProvider {
    public static void main(String[] args) {

        SpringApplication.run(OpenFeignProvider.class,args);

    }
}