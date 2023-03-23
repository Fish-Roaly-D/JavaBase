package com.roly.dubbo_zookeeper_provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboZookeeperProviderApplication.class, args);
    }

}
