package com.roily.advice.demo01.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Date: 2022/10/17/16:39
 * @Description:
 */
//声明此类为配置类
@Configuration
//开启代理
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.roily.advice.demo01")
public class ApplicationConfig {

}
