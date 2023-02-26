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
    public ResultVo<String> login(HttpSession session, String phone) {
        final UserDto user = (UserDto) session.getAttribute(phone);
        if (null != user) {
            return ResultVo.ok(JSONUtil.toJsonStr(user));
        }
        return ResultVo.error("用户无权限");
    }
}
