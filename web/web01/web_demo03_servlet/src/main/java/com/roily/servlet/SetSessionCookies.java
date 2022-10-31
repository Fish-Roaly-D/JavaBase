package com.roily.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Date: 2022/10/21/10:05
 * @Description:
 */
public class SetSessionCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session，session存在于服务端，每个用户只有一个
        final HttpSession session = req.getSession();

        session.setAttribute("name", "姓名");

        //cookie 存在于浏览器端，可存在多个
        final Cookie[] cookies = req.getCookies();

        final Cookie cookie1 = new Cookie("cookie1", "cookie1");
        final Cookie cookie2 = new Cookie("cookie2", "cookie2");

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

    }
}
