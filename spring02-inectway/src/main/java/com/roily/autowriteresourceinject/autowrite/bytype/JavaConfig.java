package com.roily.autowriteresourceinject.autowrite.bytype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2022/10/12/10:25
 * @Description:
 */
@ComponentScan(value = "com.roily.autowriteresourceinject.autowrite.bytype")
public class JavaConfig {

    @Bean("value1")
    String value1(){
        return "value1";
    }

    @Bean("value2")
    String value2(){
        return "value2";
    }

}
