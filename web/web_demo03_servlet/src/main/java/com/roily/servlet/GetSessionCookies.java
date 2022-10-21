package com.roily.servlet;

import org.springframework.util.ResourceUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Date: 2022/10/21/10:05
 * @Description:
 */
public class GetSessionCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session，session存在于服务端，每个用户只有一个
        final HttpSession session = req.getSession();
        System.err.println("session.hashCode():" + session.hashCode());
        final Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = (String) attributeNames.nextElement();
            System.out.println(attributeName + ":  " + session.getAttribute(attributeName));
        }
        //cookie 存在于浏览器端，可存在多个
        final Cookie[] cookies = req.getCookies();
        Arrays.stream(cookies).forEach(ele -> {
            System.out.println(ele.getName() + ":" + ele.getValue());
        });
    }
}
