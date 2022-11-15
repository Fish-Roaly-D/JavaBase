package com.roily.mp01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.roily.mp01.backstage.mapper"})
@SpringBootApplication
public class Mp01Application {

    public static void main(String[] args) {
        SpringApplication.run(Mp01Application.class, args);
    }

}
