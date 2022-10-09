package com.roily.constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2022/10/09/15:52
 * @Description: 通过类型注入demo javaConfig
 */

/**
 * 声明这个类为配置类，在idea中显示比较方便， 去掉也并不影响功能
 */
@Configuration
@ComponentScan("com.roily.constructor")
public class InjectConstructorConfig {

    //注入名称默认component01
    @Bean("component01aliasX")
    public Component01 component01() {
        return new Component01();
    }

    // 注入名称默认component01
    @Bean("component01alias")
    public Component01 component02() {
        return new Component01();
    }

}
