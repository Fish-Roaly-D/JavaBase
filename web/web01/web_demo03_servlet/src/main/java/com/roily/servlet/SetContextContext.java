package com.roily.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2022/10/21/9:59
 * @Description:
 */
public class SetContextContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //得到web上下文对象，相当于web容器，所有web程序共享一个servletContext
        final ServletContext servletContext = getServletContext();
        System.err.println("servletContext.hashCode():" + servletContext.hashCode());
        //往ServletContext放值
        servletContext.setAttribute("name", "姓名");

    }
}
