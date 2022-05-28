package com.roily.root.demo.aboutvalid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
        {
                "com.roily.root.demo.common.*",
                "com.roily.root.demo.aboutvalid.*"
        })
public class AboutvalidApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboutvalidApplication.class, args);
    }

}
