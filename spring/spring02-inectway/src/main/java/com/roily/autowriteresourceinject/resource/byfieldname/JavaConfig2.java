package com.roily.autowriteresourceinject.resource.byfieldname;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2022/10/12/10:25
 * @Description:
 */
@ComponentScan(value = "com.roily.autowriteresourceinject.resource.byfieldname")
public class JavaConfig2 {

    @Bean("daoComponent1alias")
    DaoComponent1 daoComponent1() {
        return new DaoComponent1();
    }

    //优先通过fieldname匹配，匹配到发现类型不对，如果将此处注掉则不会报错
    // @Bean("daoComponent1")
    DaoComponent2 daoComponent2() {
        return new DaoComponent2();
    }

}
