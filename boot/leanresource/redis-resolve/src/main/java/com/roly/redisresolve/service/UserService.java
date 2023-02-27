package com.roly.redisresolve.service;

import com.roly.redisresolve.common.util.ResultVo;
import com.roly.redisresolve.dto.UserDto;

import javax.servlet.http.HttpSession;

/**
 * @author: rolyfish
 */
public interface UserService {
    ResultVo<String> view(HttpSession session, String phone);
}
