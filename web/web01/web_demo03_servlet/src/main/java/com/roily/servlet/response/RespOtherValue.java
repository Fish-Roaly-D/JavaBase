package com.roily.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2022/11/11/11:29
 * @Description:
 */
public class RespOtherValue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应状态码
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "错误");

        //使用指定的状态向客户端发送错误响应，包含错误消息，跳转到tomcat默认错误页面
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"错误");

    }
}
