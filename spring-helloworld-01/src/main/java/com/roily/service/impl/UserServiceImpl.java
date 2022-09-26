package com.roily.service.impl;

import com.roily.entity.User;
import com.roily.mapper.UserMapper;
import com.roily.service.UserService;
import lombok.Data;

import java.util.List;

/**
 * @Date: 2022/09/26/14:26
 * @Description:
 */
@Data
public class UserServiceImpl  implements UserService {

    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
