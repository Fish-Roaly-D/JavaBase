package com.roly.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date: 2023/03/28/17:00
 * @Description:
 */
@FeignClient(name = "feignTest", url = "localhost:8081/feign",fallback = ErrorMessage.class)
public interface ProviderApi {

    @RequestMapping(value = "/test1/{data}", method = RequestMethod.GET)
    String test1(@PathVariable("data") String data);

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    String test2(@RequestBody String data);

}
