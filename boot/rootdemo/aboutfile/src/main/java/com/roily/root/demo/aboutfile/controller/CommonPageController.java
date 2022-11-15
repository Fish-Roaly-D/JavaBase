package com.roily.root.demo.aboutfile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @version 1.0.0
 * @Description 页面跳转控制器
 * @ClassName CommonPageController.java
 * @author: RoilyFish
 * @date: 2022/6/6 20:44
 */
@Slf4j
@Controller
public class CommonPageController {


    @RequestMapping(value = "/toupload", method = RequestMethod.GET)
    public String toUpload() {
        return "upload";
    }

}
