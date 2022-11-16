package com.roily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Date: 2022/11/16/14:04
 * @Description:
 */
@Controller
public class HelloSpringMvc {

    @RequestMapping(path = "/h")
    ModelAndView helloSpringMvc() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hellomvc");
        modelAndView.addObject("msg", "helloSpringMvc");
        return modelAndView;

    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("00000", 5));


    }

}
