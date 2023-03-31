package com.roly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rolyfish
 * @Date: ${YEAR}/${MONTH}/${DAY}/${TIME}
 * @Description:
 */
@EnableFeignClients
@SpringBootApplication
public class OpenFeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumer.class,args);
    }

}