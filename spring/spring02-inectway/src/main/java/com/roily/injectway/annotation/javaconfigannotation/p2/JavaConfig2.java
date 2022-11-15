package com.roily.injectway.annotation.javaconfigannotation.p2;

import com.roily.injectway.annotation.javaconfigannotation.p1.DaoDemo;
import com.roily.injectway.annotation.javaconfigannotation.p1.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2022/10/11/11:06
 * @Description:
 */
// @ComponentScan(basePackages = "com.roily.injectway.annotation.javaconfigannotation.p2")
public class JavaConfig2 {

    @Bean
    String value() {
        return "value";
    }

    @Bean
    DaoDemo2 daoDemo() {
        return new DaoDemo2();
    }

    @Bean
    ServiceDemo2 serviceDemo() {
        return new ServiceDemo2();
    }

}
