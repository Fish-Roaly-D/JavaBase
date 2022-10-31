package com.roily.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Date: 2022/10/20/17:09
 * @Description:
 */
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //不同的请求方式走不同的方法，但是业务逻辑是一样的
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        // resp.setCharacterEncoding("utf-8");
        final Object name1 = req.getAttribute("name");
        req.setAttribute("name", "name");
        final String name = req.getParameter("name");
        final String age = req.getParameter("age");
        System.out.println("name:" + name + "  age:" + age);
        //直接输出到网页上
        final PrintWriter writer = resp.getWriter();
        writer.println(name);
        writer.println(age);
        writer.close();
    }

    @Override
    public void destroy() {
        System.err.println(this.getClass().getSimpleName() + "销毁");
    }

    @Override
    public void init() throws ServletException {
        System.err.println(this.getClass().getSimpleName() + "初始化");
    }
}
