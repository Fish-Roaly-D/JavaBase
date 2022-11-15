package com.roily.aboutswagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName SwaggerController.java
 * @author: RoilyFish
 * @date: 2022/4/7 12:43
 */
@RestController
public class SwaggerController {

    @RequestMapping(value = "/tets",method = RequestMethod.POST)
    public void testController(String str){

    }
}
