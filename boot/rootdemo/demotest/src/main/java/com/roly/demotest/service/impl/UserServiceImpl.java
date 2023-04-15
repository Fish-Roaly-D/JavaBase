package com.roly.demotest.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roly.demotest.entity.User;
import com.roly.demotest.mapper.UserMapper;
import com.roly.demotest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author roilyFish
 * @since 2022-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page<User> page(int current) {
        final Page<User> userPage = new Page<>(current, 5);
        userPage.setOrders(Collections.singletonList(new OrderItem("age", true)));
        this.page(userPage);
        return userPage;
    }
}
