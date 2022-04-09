package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName GolabelConfig.java
 * @author: RoilyFish
 * @date: 2022/4/8 2:14
 */
//开启swagger注解支持
@EnableSwagger2
//声明配置类
@Configuration
public class GlobalConfig {

    //@Value("${custom.swagger.enableSwagger}")
    @Autowired
    DevEnvironment devEnvironment;

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {
        //设置哪些环境下可以访问swagger
        Profiles of = Profiles.of("dev", "pro");

        boolean enable = environment.acceptsProfiles(of);

        return new
                Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(devEnvironment.isEnableSwagger())
                .groupName("RoilyFish")
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .build()
                ;
    }

    @Bean //配置docket以配置Swagger具体参数
    public Docket docketYYC(Environment environment) {
        //设置哪些环境下可以访问swagger
        Profiles of = Profiles.of("dev", "pro");
        boolean enable = environment.acceptsProfiles(of);
        return new
                Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(devEnvironment.isEnableSwagger())
                .groupName("yyc")
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .build()
                ;
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact =
                new Contact("RoilyFish", "http://RoilyFish.com/联系人访问链接", "1056819225@qq.com");
        return new ApiInfo(
                "Swagger基本使用", // 标题
                "测试如何配置Swagger文档信息", // 描述
                "v1.0.0", // 版本
                "http://xxx.xxx", // 组织链接
                contact, // 联系人信息
                "RoilyFish---许可信息", // 许可
                "Link许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
