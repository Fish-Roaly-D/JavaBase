package com.roly.demotest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.roily.root.demo.aboutaop.entity.User;
import com.roly.demotest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemotestApplicationTests {

    @Autowired
    UserService userService;

    /**
     * 此处存在滚动分页问题
     */
    @Test
    void contextLoads() {
        final Page<User> page1 = userService.page(1);
        final Page<User> page2 = userService.page(2);
        /**
         * ==>  Preparing: SELECT id, name, age FROM user ORDER BY age ASC LIMIT ?,?
         * ==> Parameters: 5(Long), 5(Long)
         * <==    Columns: id, name, age
         * <==        Row: 5, yuyc5, 25
         * <==      Total: 1
         */
    }

}
