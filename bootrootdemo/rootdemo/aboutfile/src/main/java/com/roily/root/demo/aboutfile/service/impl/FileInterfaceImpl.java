package com.roily.root.demo.aboutfile.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roily.root.demo.aboutfile.service.FileInterface;
import com.roily.root.demo.common.common.VO.aboutfile.req.FileReqVo;
import com.roily.root.demo.common.common.VO.aboutfile.resp.FileRespVo;
import com.roily.root.demo.common.common.exception.GlobalCustomException;
import com.roily.root.demo.common.util.ResultVo;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @version 1.0.0
 * @Description 文件处理业务类
 * @ClassName FileInterfaceImpl.java
 * @author: RoilyFish
 * @date: 2022/5/28 0:11
 */
@ApiModel(value = "FileInterfaceImpl", description = "文件处理业务类")
@Service
@Slf4j
public class FileInterfaceImpl implements FileInterface {

    @Override
    public void downloadFile(String filePath, String fileName, HttpServletResponse resp) {

        File file = new File(filePath, fileName);
        if (!file.exists()) {
            log.info("文件资源不存在,{path:{}，filename:{}}", filePath, fileName);
            throw new GlobalCustomException("5000", "资源不存在");
        }
        //2、 读取文件--输入流
        InputStream input;
        //3、 写出文件--输出流
        OutputStream out;
        try {
            //1、设置resp 响应头
            resp.reset(); //设置页面不缓存,清空buffer
            resp.setCharacterEncoding("UTF-8"); //字符编码
            resp.setContentType("multipart/form-data"); //二进制传输数据
            //设置响应头 解决弹出框中文乱码问题
            resp.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

            input = new FileInputStream(file);
            //3、 写出文件--输出流
            out = resp.getOutputStream();
            byte[] buff = new byte[1024];
            int index;
            //4、执行 写出操作
            while ((index = input.read(buff)) != -1) {
                out.write(buff, 0, index);
                out.flush();
            }
            out.close();
            input.close();
        } catch (IOException e) {
            log.info("文件传输出现异常:{}", e.getMessage());
            throw new GlobalCustomException("5000", "文件传输出现异常");
        }
    }

    @Override
    public ResultVo<FileRespVo> uploadFile(FileReqVo fileReqVo, MultipartFile file) {
        if (file.isEmpty()) {
            return ResultVo.error("上传为空，请重试！", null);
        }
        try {

            //获取文件名
            String originalFilename = file.getOriginalFilename();
            log.info("文件名：{}", originalFilename);
            //文件类型
            String contentType = file.getContentType();
            log.info("文件类型：{}", contentType);
            //文件大小
            Long size = file.getSize();
            log.info("文件大小：{}", size.toString());
            //获取当前项目  父级目录
            String root = System.getProperty("user.dir");
            File fileRoot = new File(root, "/file");
            if (!fileRoot.exists()) {
                fileRoot.mkdirs();
            }
            //唯一性处理 这里简单 （雪花算法。。。。）
            long time = new Date().getTime();
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = time + "-" + uuid + "-" + originalFilename;
            log.info("文件按存储名：{}", fileName);
            //File.separator  文件分割符 =》  '/'
            file.transferTo(new File(root + File.separator + "img" + File.separator, fileName));
            log.info("真实存储路径：{}", root + File.separator + "img" + File.separator + fileName);
        } catch (IOException e) {
            throw new GlobalCustomException("5000", "文件上传异常！");
        }
        return null;
    }

}
