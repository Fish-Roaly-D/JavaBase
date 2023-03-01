package com.roly.dubbo_zookeeper_consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboZookeeperConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboZookeeperConsumerApplication.class, args);
	}

}
