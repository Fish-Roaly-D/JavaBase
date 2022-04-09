package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName User.java
 * @author: RoilyFish
 * @date: 2022/4/9 1:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "userxx.obj")
public class User {

    private String name;
    private Integer age;
    private boolean enableSwagger;

}
