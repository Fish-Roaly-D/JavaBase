package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName DemoController.java
 * @author: RoilyFish
 * @date: 2022/4/9 13:39
 */
@Api(tags = {"AboutUserController"}, description = "用户相关API", position = 1)
@RestController
public class AboutUserController {

    @RequestMapping(value = "/swagger/test2", method = RequestMethod.POST)
    @ApiOperation(
            value = "swagger测试",
            notes = "swaggerTest的冗余描述，用于对接口的详细描述",
            tags = {"TestController"},
            response = String.class,
            httpMethod = "POST",
            hidden = false)
    public String swaggerTest(@RequestBody User user) {

        return JSON.toJSONString(user);

    }

    @RequestMapping(value = "/swagger/test3", method = RequestMethod.POST)
    @ApiOperation(
            value = "swagger测试",
            notes = "swaggerTest的冗余描述，用于对接口的详细描述",
            tags = {"TestController"},
            response = String.class,
            httpMethod = "POST",
            hidden = false)
    public String aswaggerTest(@RequestBody User user) {

        return JSON.toJSONString(user);

    }


}
