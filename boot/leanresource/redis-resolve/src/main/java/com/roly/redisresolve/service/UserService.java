package com.roly.redisresolve.service;

import com.roly.redisresolve.common.util.ResultVo;
import com.roly.redisresolve.dto.UserDto;

import javax.servlet.http.HttpSession;

/**
 * @author: rolyfish
 */
public interface UserService {
    ResultVo<String> login(HttpSession session, String phone);
}
