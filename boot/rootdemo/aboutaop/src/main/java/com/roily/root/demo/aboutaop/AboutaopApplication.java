package com.roily.root.demo.aboutaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.roily.root.demo.common.*",
        "com.roily.root.demo.aboutaop.*"
        })
public class AboutaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboutaopApplication.class, args);
    }

}
