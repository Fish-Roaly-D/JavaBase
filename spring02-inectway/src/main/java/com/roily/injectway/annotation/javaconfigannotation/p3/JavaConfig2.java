package com.roily.injectway.annotation.javaconfigannotation.p3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2022/10/11/11:06
 * @Description:
 */
@ComponentScan(basePackages = "com.roily.injectway.annotation.javaconfigannotation.p3")
public class JavaConfig2 {

    @Bean
    String value() {
        return "value";
    }

}
