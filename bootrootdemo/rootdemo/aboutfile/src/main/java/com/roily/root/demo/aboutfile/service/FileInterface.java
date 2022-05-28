package com.roily.root.demo.aboutfile.service;

import com.roily.root.demo.common.common.VO.aboutfile.req.FileReqVo;
import com.roily.root.demo.common.common.VO.aboutfile.resp.FileRespVo;
import com.roily.root.demo.common.util.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0.0
 * @Description 文件统一处理接口
 * @ClassName FileInterface.java
 * @author: RoilyFish
 * @date: 2022/5/27 23:46
 */
public interface FileInterface {

    void downloadFile(String filePath, String fileName, HttpServletResponse resp);

    ResultVo<FileRespVo> uploadFile(MultipartFile file);

}
