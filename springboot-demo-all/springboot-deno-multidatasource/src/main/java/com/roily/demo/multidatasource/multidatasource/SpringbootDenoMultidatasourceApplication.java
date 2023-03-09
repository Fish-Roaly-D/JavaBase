package com.roily.demo.multidatasource.multidatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot配置多数据源
 */
@Slf4j
@RestController
@SpringBootApplication
public class SpringbootDenoMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDenoMultidatasourceApplication.class, args);
    }

    @PostMapping("/init")
    public void test(){
        System.out.println(1);
        log.info("Hello World");
    }

}
