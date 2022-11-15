package com.roily.service.impl;

import com.roily.entity.User;
import com.roily.mapper.UserMapper;
import com.roily.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 2022/09/26/14:26
 * @Description:
 */
@Service
@Data
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }


    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
