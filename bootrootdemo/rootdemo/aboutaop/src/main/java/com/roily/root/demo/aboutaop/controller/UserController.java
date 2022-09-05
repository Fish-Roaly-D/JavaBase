package com.roily.root.demo.aboutaop.controller;

import com.roily.root.demo.aboutaop.common.aspect.annotation.MethodLogAnnotation;
import com.roily.root.demo.aboutaop.common.util.enums.Enums;
import com.roily.root.demo.aboutaop.entity.User;
import com.roily.root.demo.aboutaop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @since 2022-09-05
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @MethodLogAnnotation(businessType = Enums.BusinessType.QUERY, desc = "查询")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public List<User> list() {
        return userService.page().getRecords();
    }

}
