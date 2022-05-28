package com.roily.root.demo.aboutfile.controller;

import com.roily.root.demo.aboutfile.service.FileInterface;
import com.roily.root.demo.common.common.exception.GlobalCustomException;
import com.roily.root.demo.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0.0
 * @Description 文件下载
 * @ClassName FileDownload.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:17
 */
@Slf4j
@RestController
public class FileDownload {

    @Resource
    FileInterface fileInterface;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResultVo download(HttpServletResponse resp) {

        String filePath = System.getProperty("user.dir") + "/file";
        String filename = "downlad.txt";
        log.info("文件路径：{},文件名称：{}", filePath, filename);
        throw new GlobalCustomException("5000", "资源不存在");
        //fileInterface.downloadFile(filePath, filename, resp);
    }


}
