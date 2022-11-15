package com.roily.aboutswagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @version 1.0.0
 * @Description
 * @ClassName GloableConfig.java
 * @author: RoilyFish
 * @date: 2022/4/7 12:47
 */
//开启swagger支持
@EnableOpenApi
@EnableWebMvc
@Configuration
public class GloableConfig {

    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    //@Value(value = "${custom.swagger.enabled}")
    Boolean swaggerEnabled;


}
