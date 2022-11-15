package com.roily.mp01.backstage.controller;

import com.roily.mp01.backstage.entity.User;
import com.roily.mp01.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author roilyFish
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/backstage/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "list", method = RequestMethod.POST)
    public List<User> list() {
        return userService.list();
    }

}
