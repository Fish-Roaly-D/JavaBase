package com.roly.demotest.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author rolyfish
 * @Date: 2022/09/05/16:40
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.roly.demotest.mapper"})
public class MybatisPlusConfig {

    /**
     * mp 分页插件
     * @return MybatisPlusInterceptor 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 向MyBatis-Plus的过滤器链中添加分页拦截器，需要设置数据库类型（主要用于分页方言）
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }


    @Component
    public static class MyFillHandler implements MetaObjectHandler {

        @Override
        public void insertFill(MetaObject metaObject) {
            // 起始版本 3.3.0(推荐使用)
            this.strictInsertFill(metaObject, "create_time", Date.class, new Date());
            this.strictInsertFill(metaObject, "update_time", Date.class, new Date());
            this.strictInsertFill(metaObject, "is_delete", Date.class, new Date());
        }
        @Override
        public void updateFill(MetaObject metaObject) {
            // 起始版本 3.3.0(推荐)
            this.strictUpdateFill(metaObject, "update_time", Date.class, new Date());
        }
    }

}
