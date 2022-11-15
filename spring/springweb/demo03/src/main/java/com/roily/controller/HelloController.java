package com.roily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @classname：HelloController
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/16 01:26
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/d")
    ModelAndView hw() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg", "HelloController");
        return modelAndView;
    }

}
