package com.roily.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName cccc.java
 * @author: RoilyFish
 * @date: 2022/4/9 17:43
 */
@Api
@RestController
public class cccc {



    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String rr(){
        return "xx";
    }


}
