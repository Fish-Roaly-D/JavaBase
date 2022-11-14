package com.roily.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2022/11/14/9:58
 * @Description:
 */
public class RespSendRedirectInsite extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //不可直接重定向访问web-inf下静态资源,爆出404
        // resp.sendRedirect(this.getServletContext().getContextPath() + "/WEB-INF/jsp/reqDispatcher.jsp");

        //可直接访问
        resp.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
