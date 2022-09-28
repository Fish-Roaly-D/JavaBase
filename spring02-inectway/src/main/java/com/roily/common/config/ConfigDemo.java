package com.roily.common.config;

import com.roily.dao.DaoDemo;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2022/09/27/16:28
 * @Description:
 */
@ComponentScan(basePackages = "com.roily")
@Configuration
public class ConfigDemo {

    @Bean("daoDemo")
    public DaoDemo daoDemo(){
        return new DaoDemo();
    }

    @Bean("daoDemoAlias")
    public DaoDemo daoDemoAlias(){
        return new DaoDemo();
    }

}
