package com.roly.redisresolve.controller;

import com.roly.redisresolve.common.util.ResultVo;
import com.roly.redisresolve.dto.UserDto;
import com.roly.redisresolve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: rolyfish
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login/{phone}")
    ResultVo<String> login(HttpSession session, @PathVariable("phone") String phone) {
        return userService.login(session, phone);
    }

    /**
     * 初始化session
     *
     * @param session
     * @return
     */
    @PostMapping("init")
    ResultVo<String> init(HttpSession session) {
        final UserDto user = UserDto.builder().id(1).name("李自成").phone("17501568531").build();
        session.setAttribute(user.getPhone(), user);
        return ResultVo.ok();
    }

}
