package com.roily.autowriteresourceinject.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2022/10/12/10:25
 * @Description:
 */
@ComponentScan(value = "com.roily.autowriteresourceinject.resource")
public class JavaConfig {

    @Bean
    DaoComponent1 daoComponent1() {
        return new DaoComponent1();
    }

    @Bean
    DaoComponent2 daoComponent2() {
        return new DaoComponent2();
    }
}
