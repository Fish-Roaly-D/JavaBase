package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName TestController.java
 * @author: RoilyFish
 * @date: 2022/4/9 1:54
 */
@Api(tags = {"TestController"}, description = "排序关于", position = 0)
@RestController
public class TestController {

    @RequestMapping(value = "/swagger/test", method = RequestMethod.POST)
    public String query(@RequestBody User user) {
        //doQuery
        return JSON.toJSONString(user);

    }

    @RequestMapping(value = "/swagger/testxx", method = RequestMethod.POST)
    public String query2(@RequestBody @ApiParam(name = "addressxxx",value = "请求参数说明") Address address) {
        //doQuery
        return JSON.toJSONString(address);

    }

}
