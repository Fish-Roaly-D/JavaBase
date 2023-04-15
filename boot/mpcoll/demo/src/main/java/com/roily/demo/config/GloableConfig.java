package com.roily.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName GloableConfig.java
 * @author: RoilyFish
 * @date: 2022/4/9 17:18
 */
@EnableSwagger2
@EnableOpenApi
@EnableWebMvc
@Configuration
public class GloableConfig implements WebMvcConfigurer {

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {
        //设置哪些环境下可以访问swagger
        Profiles of = Profiles.of("dev", "pro");

        boolean enable = environment.acceptsProfiles(of);

        return new
                Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
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
                .enable(true)
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("index.html")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

        registry.addResourceHandler("/webjars/springfox-swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

}
