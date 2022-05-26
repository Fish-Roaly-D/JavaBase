package com.roily.root.demo.aboutfile.controller;

import com.roily.root.demo.common.common.exception.GlobalCustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Description  文件下载
 * @ClassName FileDownload.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:17
 */
@RestController
public class FileDownload {

    @RequestMapping("/globalException/test")
    public String geh(int i){

        if (i == 0){
            GlobalCustomException xx = new GlobalCustomException("200", "xxxxasdasd撒打算x");
            throw xx;
        }

        return "123";
    }


}
