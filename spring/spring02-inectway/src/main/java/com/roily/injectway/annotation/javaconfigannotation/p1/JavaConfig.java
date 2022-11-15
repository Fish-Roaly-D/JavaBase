package com.roily.injectway.annotation.javaconfigannotation.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @Date: 2022/10/11/11:06
 * @Description:
 */
public class JavaConfig {

    @Bean
    String value(){
        return "value";
    }

    @Bean
    DaoDemo daoDemo(@Autowired String value){
        return new DaoDemo().setValue(value);
    }

    @Bean
    ServiceDemo serviceDemo(@Autowired DaoDemo daoDemo){
        return new ServiceDemo().setDaoDemo(daoDemo);
    }

}
