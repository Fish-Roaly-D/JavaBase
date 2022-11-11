package com.roily.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Date: 2022/10/24/11:59
 * @Description:
 */
public class ResponseSendCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        respSendCookie(req, resp);

    }

    private static void respSendCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.addCookie(new Cookie("cookie1", "value1"));
        resp.addCookie(new Cookie("cookie2", "value2"));
        String reqp = "/WEB-INF/jsp/cookiesTest.jsp";
        req.getRequestDispatcher(reqp).forward(req, resp);

    }

}
