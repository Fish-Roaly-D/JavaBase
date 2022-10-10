package com.roily.injectway.setter.javaconfig;

import org.springframework.context.annotation.Bean;

/**
 * @Date: 2022/10/10/10:20
 * @Description:
 */
public class SetterConfig {


    @Bean
    String name(){
        return "name";
    }

    @Bean
    User user(){
        return new User();
    }


}
