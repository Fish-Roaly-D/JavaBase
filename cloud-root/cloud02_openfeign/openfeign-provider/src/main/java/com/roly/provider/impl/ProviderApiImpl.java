package com.roly.provider.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class ProviderApiImpl {

    @RequestMapping(value = "/test1/{data}", method = RequestMethod.GET)
    String test1(@PathVariable("data") String data) {
        return "test1" + data;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    String test2(@RequestBody String data) {
        return "test2" + data;
    }
}

