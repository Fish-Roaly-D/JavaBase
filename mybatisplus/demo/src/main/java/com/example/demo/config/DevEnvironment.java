package com.example.demo.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName DevEnvironment.java
 * @author: RoilyFish
 * @date: 2022/4/9 3:13
 */
@Data
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "enviroment")
public class DevEnvironment {

    private boolean enableSwagger;

}
