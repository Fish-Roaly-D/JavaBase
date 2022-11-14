package com.roily.servlet.servletcontext;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Date: 2022/11/14/17:18
 * @Description:
 */
public class ServletContextApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final ServletContext servletContext = getServletContext();

        //获取根目录下资源文件
        // servletContext.getResourceAsStream()

        //程序根路径
        final String contextPath = servletContext.getContextPath();
        System.out.println("servletContext.getContextPath():" + contextPath);

        //web容器初始化参数
        final String s = servletContext.getInitParameter("");
        final Enumeration initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            final String initParam = (String) initParameterNames.nextElement();
            System.out.println(initParam + " :" + servletContext.getInitParameter(initParam));
        }

        //返回一个字符串，其中包含给定虚拟路径的真实路径。
        //E:\programmeTools\idea\git\JavaBase\web\web01\web_demo03_servlet\target\web_demo03_servlet\index.jsp
        final String realPath = servletContext.getRealPath("/index.jsp");
        System.out.println("servletContext.getRealPath(\"/index.jsp\"):" + realPath);

        //获取servlet 总是返回null 会被弃用
        // final ServletName servlet = (ServletName) servletContext.getServlet("servletName");
        // servlet.doPost(req, resp);

    }
}
