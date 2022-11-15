package com.roily.autowriteresourceinject.inject.byname;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2022/10/12/10:25
 * @Description:
 */
@ComponentScan(value = "com.roily.autowriteresourceinject.inject.byname")
public class JavaConfig {

    @Bean
    DaoComponent1 daoComponent1() {
        return new DaoComponent1();
    }

    @Bean
    DaoComponent1 daoComponent2() {
        return new DaoComponent1();
    }

}
