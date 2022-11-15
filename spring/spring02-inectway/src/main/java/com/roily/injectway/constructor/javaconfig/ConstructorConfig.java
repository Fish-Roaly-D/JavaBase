package com.roily.injectway.constructor.javaconfig;

import org.springframework.context.annotation.Bean;

public class ConstructorConfig {

    @Bean
    String name(){
        return "name";
    }


    @Bean
    String age(){
        return "age";
    }


    @Bean
    String email(){
        return "email";
    }

    @Bean
    Person person(String name, String age, String email){
        return new Person(name,age,email);
    }

}