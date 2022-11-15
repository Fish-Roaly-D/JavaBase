package com.roily.common.config;

import com.roily.dao.UserDao;
import com.roily.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2022/09/27/15:25
 * @Description:
 */
@Configuration
public class ApplicationConfig {

    @Bean
    UserDao userDao(){
        return new UserDao();
    }
    //
    // @Bean
    // UserService userService(){
    //     return new UserService();
    // }

}
