package com.roily.mp01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roily.mp01.entity.User;
import com.roily.mp01.mapper.UserMapper;
import com.roily.mp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author roilyFish
 * @since 2023-02-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selOneXml() {
        return userMapper.selOneXml();
    }
}
