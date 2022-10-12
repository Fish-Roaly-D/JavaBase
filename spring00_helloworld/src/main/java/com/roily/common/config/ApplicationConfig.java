package com.roily.common.config;

import com.roily.common.aop.LogAspect;
import com.roily.mapper.UserMapper;
import com.roily.service.UserService;
import com.roily.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @classname：ApplicationConfig
 * @author: rolyfish
 * @description:
 * @date: 2022/9/26 23:06
 */
//@EnableAspectJAutoProxy//aop,支持代理类
//@Configuration//声明此类为配置类
public class ApplicationConfig {

    /**
     * 数据库配置
     *
     * @return
     */
    @Bean("jdbcProperties")
    public Properties jdbcProperties() {
        final InputStream in = ApplicationConfig.class.getClassLoader().getResourceAsStream("db.properties");
        final Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Bean("dataSource")
    public DataSource driverManagerDataSource(Properties jdbcProperties) {
        return new DriverManagerDataSource(jdbcProperties.getProperty("url"), jdbcProperties);
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean("sqlSession")
    public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("userMapper")
    public UserMapper userMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(UserMapper.class);
    }

    @Bean("userService")
    public UserService userService(UserMapper userMapper) {
        final UserServiceImpl userService = new UserServiceImpl();
        userService.setUserMapper(userMapper);
        return userService;
    }

    @Bean("logAspect")
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
