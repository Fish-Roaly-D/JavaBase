package com.roly.redisresolve.service.service.impl;

import cn.hutool.json.JSONUtil;
import com.roly.redisresolve.common.util.ResultVo;
import com.roly.redisresolve.dto.UserDto;
import com.roly.redisresolve.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author: rolyfish
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResultVo<String> view(HttpSession session, String phone) {

        return ResultVo.ok();
    }
}
