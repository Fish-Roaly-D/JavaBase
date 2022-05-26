package com.roily.root.demo.aboutfile.controller;

import com.roily.root.demo.common.common.exception.GlobalCustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @version 1.0.0
 * @Description 文件下载
 * @ClassName FileDownload.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:17
 */
@RestController
public class FileDownload {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(HttpServletResponse resp) {
        String path = System.getProperty("user.dir");
        String filename = "download.txt";
        File file = new File(path + "/file", filename);
        if (!file.exists()) {
            return "资源不存在";
        }
        //2、 读取文件--输入流
        InputStream input = null;
        //3、 写出文件--输出流
        OutputStream out = null;
        try {
            //1、设置resp 响应头
            resp.reset(); //设置页面不缓存,清空buffer
            resp.setCharacterEncoding("UTF-8"); //字符编码
            resp.setContentType("multipart/form-data"); //二进制传输数据
            //设置响应头 解决弹出框中文乱码问题
            resp.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(filename, "UTF-8"));

            input = new FileInputStream(file);
            //3、 写出文件--输出流
            out = resp.getOutputStream();
            byte[] buff = new byte[1024];
            int index = 0;
            //4、执行 写出操作
            while ((index = input.read(buff)) != -1) {
                out.write(buff, 0, index);
                out.flush();
            }
            out.close();
            input.close();
        } catch (IOException e) {

        }
        return null;
    }


}
