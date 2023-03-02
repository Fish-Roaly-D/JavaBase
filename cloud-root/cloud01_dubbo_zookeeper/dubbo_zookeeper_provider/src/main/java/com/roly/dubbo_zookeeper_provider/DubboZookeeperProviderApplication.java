package com.roly.dubbo_zookeeper_provider;

import com.roly.cloud.service.Consumer2Provider;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableDubbo
public class DubboZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboZookeeperProviderApplication.class, args);
    }

}
