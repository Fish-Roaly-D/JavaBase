package com.roily;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2022/10/18/17:20
 * @Description:
 */
@RestController
public class mvc01 {

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    String test(){
        return "hello Spring mvc";
    }

}
