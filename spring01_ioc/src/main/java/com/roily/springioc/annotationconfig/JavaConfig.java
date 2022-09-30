package com.roily.springioc.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2022/09/30/10:24
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = "com.roily.springioc.annotationconfig")
public class JavaConfig {

    @Bean(value = "daoComponent0x")
    DaoComponent daoComponent(){
        return new DaoComponent();
    }

}
