package com.roily.mp01.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Date: 2022/09/05/16:40
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.roily.mp01.mapper"})
public class MybatisPlusConfig {

    /**
     * mp 分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 向MyBatis-Plus的过滤器链中添加分页拦截器，需要设置数据库类型（主要用于分页方言）
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }


    @Component
    public static class MyFillHandler implements MetaObjectHandler {
        @Override
        public void insertFill(MetaObject metaObject) {
            // 起始版本 3.3.0(推荐使用)
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
            this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
            this.strictInsertFill(metaObject, "isDelete", Integer.class, 0);
        }
        @Override
        public void updateFill(MetaObject metaObject) {
            // 起始版本 3.3.0(推荐)
            this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        }
    }
}
