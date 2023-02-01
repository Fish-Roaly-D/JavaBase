package com.roily.root.demo.aboutaop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.roily.root.demo.aboutaop.entity.User;
import com.roily.root.demo.aboutaop.mapper.UserMapper;
import com.roily.root.demo.aboutaop.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public Page<User> page() {

        final Page<User> userPage = new Page<>(1, 10);
        userPage.setOrders(Collections.singletonList(new OrderItem("id", true)));

        this.page(userPage, new LambdaQueryWrapper<User>()
                .in(User::getId, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));

        return userPage;

    }
}
