package com.roly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientFactory;
import org.springframework.context.annotation.Bean;

/**
 * @Date: ${YEAR}/${MONTH}/${DAY}/${TIME}
 * @Description:
 */
@EnableFeignClients
@SpringBootApplication
public class OpenFeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumer.class,args);
    }

    @Bean
    FeignClientFactory feignClientFactory(){

        final FeignClientFactory feignClientFactory = new FeignClientFactory();

        return feignClientFactory;
    }

}